package net.dekapx.demoapp.service;

import net.dekapx.demoapp.domain.TradeTransaction;

import java.util.List;

public interface TradeTransactionService {
    List<TradeTransaction> findTransactions(Integer limit);
}
