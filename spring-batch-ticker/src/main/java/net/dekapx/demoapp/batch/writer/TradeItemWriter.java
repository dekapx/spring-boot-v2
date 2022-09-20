package net.dekapx.demoapp.batch.writer;

import lombok.extern.slf4j.Slf4j;
import net.dekapx.demoapp.domain.TradeHistory;
import net.dekapx.demoapp.domain.TradeTransaction;
import net.dekapx.demoapp.service.TradeHistoryService;
import net.dekapx.demoapp.service.TradeProcessorService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Component("tradeItemWriter")
public class TradeItemWriter implements ItemWriter<TradeTransaction> {
    private final TradeProcessorService tradeProcessorService;

    @Autowired
    public TradeItemWriter(final TradeProcessorService tradeProcessorService) {
        this.tradeProcessorService = tradeProcessorService;
    }

    @Override
    public void write(final List<? extends TradeTransaction> transactions) {
        transactions.forEach(transaction
                -> this.tradeProcessorService.processTransactions(transaction));
    }
}
