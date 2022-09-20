package net.dekapx.demoapp.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TradeJobExecutionListener extends JobExecutionListenerSupport {
    @Override
    public void beforeJob(final JobExecution jobExecution) {
        log.info("--------------------------------- BATCH JOB STARTED ---------------------------------");
    }

    @Override
    public void afterJob(final JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("--------------------------------- BATCH JOB COMPLETED ---------------------------------");
        }
    }
}
