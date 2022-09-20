package net.dekapx.demoapp.service;

import lombok.extern.slf4j.Slf4j;
import net.dekapx.demoapp.domain.TradeHistory;
import net.dekapx.demoapp.domain.TradeTransaction;
import net.dekapx.demoapp.handler.TradeHandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Slf4j
@Service
public class TradeProcessorServiceImpl implements TradeProcessorService {
    private TradeHandlerFactory factory;

    @Autowired
    public TradeProcessorServiceImpl(final TradeHandlerFactory factory) {
        this.factory = factory;
    }


    @Override
    public void processTransactions(final TradeTransaction tradeTransaction) {

    }

    private Function<TradeTransaction, TradeHistory> toTradeHistory = (transaction) -> {
        final var history = new TradeHistory();
        history.setTradeId(transaction.getTradeId());
        history.setTradeName(transaction.getTradeName());
        history.setPrice(transaction.getPrice());
        history.setTransactionDate(transaction.getTransactionDate());
        return history;
    };
}
