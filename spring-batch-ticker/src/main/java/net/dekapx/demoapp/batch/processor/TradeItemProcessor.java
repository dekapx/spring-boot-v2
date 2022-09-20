package net.dekapx.demoapp.batch.processor;

import lombok.extern.slf4j.Slf4j;
import net.dekapx.demoapp.domain.TradeTransaction;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component("tradeItemProcessor")
public class TradeItemProcessor implements ItemProcessor<TradeTransaction, TradeTransaction> {
    @Override
    public TradeTransaction process(final TradeTransaction tradeTransaction) {
        return tradeTransaction;
    }
}
