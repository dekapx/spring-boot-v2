package net.dekapx.demoapp.config;

import net.dekapx.demoapp.listener.TradeJobExecutionListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.SimpleJobRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    @Value("${trade.batch.size}")
    private Integer batchSize;

    @Value("${trade.batch.concurrency.limit}")
    private Integer batchConcurrencyLimit;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    @Qualifier("tradeItemReader")
    private ItemReader reader;

    @Autowired
    @Qualifier("tradeItemProcessor")
    private ItemProcessor processor;

    @Autowired
    @Qualifier("tradeItemWriter")
    private ItemWriter writer;

    @Autowired
    private TradeJobExecutionListener tradeJobExecutionListener;

    @Bean
    public Job processJob() {
        return jobBuilderFactory
                .get("processJob")
                .incrementer(new RunIdIncrementer())
                .listener(tradeJobExecutionListener)
                .flow(step1()).end().build();
    }

    @Bean
    public JobRepository jobRepository() {
        return null;
    }

    @Bean
    public SimpleAsyncTaskExecutor simpleAsyncTaskExecutor() {
        final SimpleAsyncTaskExecutor simpleAsyncTaskExecutor = new SimpleAsyncTaskExecutor();
        simpleAsyncTaskExecutor.setConcurrencyLimit(Integer.valueOf(batchConcurrencyLimit));
        return simpleAsyncTaskExecutor;
    }

    @Bean
    public SimpleJobLauncher jobLauncher(final JobRepository jobRepository) {
        final SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository);
        jobLauncher.setTaskExecutor(simpleAsyncTaskExecutor());
        return jobLauncher;
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<String, String> chunk(batchSize)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .throttleLimit(5)
                .build();
    }
}
