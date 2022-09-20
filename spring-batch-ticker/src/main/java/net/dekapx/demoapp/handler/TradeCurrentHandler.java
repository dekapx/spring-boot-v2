package net.dekapx.demoapp.handler;

import net.dekapx.demoapp.domain.AbstractBaseEntity;
import net.dekapx.demoapp.domain.TradeCurrent;

public class TradeCurrentHandler implements TradeHandler {
    @Override
    public <T extends AbstractBaseEntity> void handleTrade(final T trade) {

    }

    @Override
    public String getType() {
        return TradeCurrent.class.getTypeName();
    }
}
