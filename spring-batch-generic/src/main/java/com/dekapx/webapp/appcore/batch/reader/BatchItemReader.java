package com.dekapx.webapp.appcore.batch.reader;

import com.dekapx.webapp.appcore.batch.model.ItemReaderWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Slf4j
@StepScope
@Component("batchItemReader")
public class BatchItemReader implements ItemReader<ItemReaderWrapper>, InitializingBean {
    @Override
    public ItemReaderWrapper read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
