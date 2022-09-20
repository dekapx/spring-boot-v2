package net.dekapx.demoapp.service;

import lombok.extern.slf4j.Slf4j;
import net.dekapx.demoapp.domain.TradeTransaction;
import net.dekapx.demoapp.repository.TradeTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class TradeTransactionServiceImpl implements TradeTransactionService {
    private final TradeTransactionRepository repository;

    @Autowired
    public TradeTransactionServiceImpl(final TradeTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TradeTransaction> findTransactions(final Integer limit) {
        return this.repository.findTransactions(limit);
    }
}
