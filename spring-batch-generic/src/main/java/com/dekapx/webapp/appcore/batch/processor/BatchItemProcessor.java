package com.dekapx.webapp.appcore.batch.processor;

import com.dekapx.webapp.appcore.batch.model.ItemProcessorWrapper;
import com.dekapx.webapp.appcore.batch.model.ItemReaderWrapper;
import com.dekapx.webapp.appcore.model.AbstractBaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component("batchItemProcessor")
public class BatchItemProcessor implements ItemProcessor<ItemReaderWrapper, ItemProcessorWrapper> {
    @Override
    public ItemProcessorWrapper process(final ItemReaderWrapper itemReaderWrapper) throws Exception {
        return null;
    }
}
