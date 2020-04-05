package com.dekapx.springboot.batch.config;

import com.dekapx.springboot.batch.listener.JobCompletionListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    @Qualifier("contactItemReader")
    private ItemReader reader;

    @Autowired
    @Qualifier("contactItemProcessor")
    private ItemProcessor processor;

    @Autowired
    @Qualifier("contactItemWriter")
    private ItemWriter writer;

    @Bean
    public JobExecutionListener listener() {
        return new JobCompletionListener();
    }

    @Bean
    public Job processJob() {
        return jobBuilderFactory
                .get("processJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener())
                .flow(step1()).end().build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<String, String> chunk(10) // marked as 10
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .throttleLimit(20)  // added throttle limit...
                .build();
    }
}
