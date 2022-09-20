package net.dekapx.demoapp.service;

import lombok.extern.slf4j.Slf4j;
import net.dekapx.demoapp.domain.TradeCurrent;
import net.dekapx.demoapp.repository.TradeCurrentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TradeCurrentServiceImpl implements TradeCurrentService {
    @Autowired
    private final TradeCurrentRepository repository;

    @Autowired
    public TradeCurrentServiceImpl(final TradeCurrentRepository repository) {
        this.repository = repository;
    }


    @Override
    public void create(final TradeCurrent tradeCurrent) {
        this.repository.save(tradeCurrent);
    }
}
