package net.dekapx.demoapp.batch.listener;

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
public class TradeJobExecutionListenerSupport extends JobExecutionListenerSupport {
    @Override
    public void beforeJob(final JobExecution jobExecution) {
        log.info("-------------------- BATCH JOB STARTED --------------------");
    }

    @Override
    public void afterJob(final JobExecution jobExecution) {
        final BatchStatus batchStatus = jobExecution.getStatus();
        switch (batchStatus) {
            case COMPLETED:
                handleBatchJobCompletion(jobExecution);
                break;
            case FAILED:
                handleBatchJobFailure(jobExecution);
                break;
            default:
                break;
        }
    }

    private void handleBatchJobCompletion(final JobExecution jobExecution) {
        log.info("-------------------- BATCH JOB COMPLETED --------------------");
        logBatchExecutionTime(jobExecution);
    }

    private void handleBatchJobFailure(final JobExecution jobExecution) {
        log.info("-------------------- BATCH JOB FAILED --------------------");
    }

    private void logBatchExecutionTime(final JobExecution jobExecution) {
        final LocalDateTime startTime = toLocalDateTime(jobExecution.getCreateTime());
        final LocalDateTime endTime = toLocalDateTime(jobExecution.getEndTime());
        final Duration duration = Duration.between(startTime, endTime);
        log.info("Batch job completed in [{}] seconds...", duration.getSeconds());
    }

    private LocalDateTime toLocalDateTime(final Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}
