package com.dekapx.webapp.appcore.batch.writer;

import com.dekapx.webapp.appcore.batch.model.ItemWriterWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component("batchItemWriter")
public class BatchItemWriter implements ItemWriter<ItemWriterWrapper> {
    @Override
    public void write(final List<? extends ItemWriterWrapper> list) throws Exception {

    }
}
