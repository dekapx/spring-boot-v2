package net.dekapx.demoapp.repository;

import net.dekapx.demoapp.domain.TradeTransaction;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TradeTransactionRepositoryITest {
    private static final String TRADE_ID = "DMMY";
    private static final String TRADE_NAME = "DUMMY CORP, INC";
    private static final BigDecimal PRICE = new BigDecimal(100.50);

    @Autowired
    private TradeTransactionRepository repository;

    @Order(1)
    @Test
    public void shouldFindAndReturnAllTradeTransactions() {
        var tradeTransactions = this.repository.findAll();
        assertThat(tradeTransactions)
                .isNotNull()
                .isNotEmpty()
                .hasAtLeastOneElementOfType(TradeTransaction.class);
    }

    @Order(2)
    @Test
    public void shouldFindAndReturnTradeTransactionsByLimit() {
        var tradeTransactions = this.repository.findTransactions(3);
        assertThat(tradeTransactions)
                .isNotNull()
                .isNotEmpty()
                .hasSize(3)
                .hasAtLeastOneElementOfType(TradeTransaction.class);
    }

    @Order(3)
    @Test
    public void createVerifyAndCleanUpTransaction() {
        create();
        verify();
        cleanUp();
    }

    private void create() {
        var tradeTransaction = buildTradeTransaction.get();
        this.repository.save(tradeTransaction);
    }

    private void verify() {
        var tradeTransaction = this.repository.findByTradeId(TRADE_ID);
        assertThat(tradeTransaction).isNotNull()
                .satisfies(t -> {
                            assertThat(t.getTradeId()).isEqualTo(TRADE_ID);
                            assertThat(tradeTransaction.getTradeName()).isEqualTo(TRADE_NAME);
                        });
    }

    private void cleanUp() {
        var tradeTransaction = this.repository.findByTradeId(TRADE_ID);
        this.repository.delete(tradeTransaction);
    }

    private Supplier<TradeTransaction> buildTradeTransaction = () -> {
        var transaction = new TradeTransaction();
        transaction.setTradeId(TRADE_ID);
        transaction.setTradeName(TRADE_NAME);
        transaction.setPrice(PRICE);
        transaction.setTransactionDate(new Date());
        return transaction;
    };
}
