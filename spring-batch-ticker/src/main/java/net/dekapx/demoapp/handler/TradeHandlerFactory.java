package net.dekapx.demoapp.handler;

import net.dekapx.demoapp.domain.AbstractBaseEntity;

public interface TradeHandlerFactory {
    <T extends AbstractBaseEntity> TradeHandler getTradeHandler(T entity);
}
