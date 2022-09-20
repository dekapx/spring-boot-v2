package net.dekapx.demoapp.handler;

import net.dekapx.demoapp.domain.AbstractBaseEntity;

public interface TradeHandler {
    <T extends AbstractBaseEntity> void  handleTrade(T trade);

    String getType();
}
