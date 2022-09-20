package net.dekapx.demoapp.repository;

import net.dekapx.demoapp.domain.TradeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeTransactionRepository extends JpaRepository<TradeTransaction, Long> {
    TradeTransaction findByTradeId(String tradeId);

    @Query(value = "select * from trade_trans order by id desc limit :limit", nativeQuery = true)
    List<TradeTransaction> findTransactions(@Param("limit") Integer limit);
}
