package com.dekapx.webapp.appcore.batch.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Slf4j
@Component
public class BatchJobExecutionListener extends JobExecutionListenerSupport {
    @Override
    public void beforeJob(final JobExecution jobExecution) {
        log.info("--------------------------------- BATCH JOB STARTED ---------------------------------");
    }

    @Override
    public void afterJob(final JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("--------------------------------- BATCH JOB COMPLETED ---------------------------------");
            logExecutionTime(jobExecution);
        }
    }

    private void logExecutionTime(final JobExecution jobExecution) {
        final LocalDateTime startDate = toLocalDate(jobExecution.getCreateTime());
        final LocalDateTime endDate = toLocalDate(jobExecution.getEndTime());
        final Duration duration = Duration.between(startDate, endDate);
        final long seconds = duration.getSeconds();
        log.info("--------------------------------- JOB COMPLETION TIME IN SECONDS: [{}]...", seconds);
    }

    private LocalDateTime toLocalDate(final Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}
