package net.dekapx.demoapp.service;

import net.dekapx.demoapp.domain.TradeTransaction;

public interface TradeProcessorService {
    void processTransactions(TradeTransaction tradeTransaction);
}
