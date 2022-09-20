package net.dekapx.demoapp.batch.reader;

import lombok.extern.slf4j.Slf4j;
import net.dekapx.demoapp.domain.TradeTransaction;
import net.dekapx.demoapp.service.TradeTransactionService;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@StepScope
@Component("tradeItemReader")
public class TradeItemReader implements ItemReader<TradeTransaction>, InitializingBean {
    @Value("${trade.batch.limit}")
    private Integer limit;

    private List<TradeTransaction> tradeTransactions;

    private final TradeTransactionService tradeTransactionService;

    @Autowired
    public TradeItemReader(final TradeTransactionService tradeTransactionService) {
        this.tradeTransactionService = tradeTransactionService;
    }

    @Override
    public void afterPropertiesSet() {
        this.tradeTransactions = this.tradeTransactionService.findTransactions(limit);
    }

    @Override
    public TradeTransaction read() {
        return (!this.tradeTransactions.isEmpty()) ? this.tradeTransactions.remove(0) : null;
    }
}
