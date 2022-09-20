package net.dekapx.demoapp.repository;

import net.dekapx.demoapp.domain.TradeCurrent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeCurrentRepository extends JpaRepository<TradeCurrent, Long> {
}
