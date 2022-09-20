package net.dekapx.demoapp.service;

import lombok.extern.slf4j.Slf4j;
import net.dekapx.demoapp.domain.TradeHistory;
import net.dekapx.demoapp.repository.TradeHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class TradeHistoryServiceImpl implements TradeHistoryService {
    private final TradeHistoryRepository tradeHistoryRepository;

    @Autowired
    public TradeHistoryServiceImpl(final TradeHistoryRepository tradeHistoryRepository) {
        this.tradeHistoryRepository = tradeHistoryRepository;
    }

    @Override
    public void create(final TradeHistory tradeHistory) {
        this.tradeHistoryRepository.save(tradeHistory);
    }
}
