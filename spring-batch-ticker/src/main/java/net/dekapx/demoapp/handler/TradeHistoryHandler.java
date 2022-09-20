package net.dekapx.demoapp.handler;

import net.dekapx.demoapp.domain.AbstractBaseEntity;
import net.dekapx.demoapp.domain.TradeHistory;
import org.springframework.stereotype.Component;

@Component
public class TradeHistoryHandler implements TradeHandler {
    @Override
    public <T extends AbstractBaseEntity> void handleTrade(final T trade) {

    }

    @Override
    public String getType() {
        return TradeHistory.class.getTypeName();
    }
}
