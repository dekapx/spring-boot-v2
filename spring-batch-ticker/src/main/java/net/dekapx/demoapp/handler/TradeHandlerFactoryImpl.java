package net.dekapx.demoapp.handler;

import net.dekapx.demoapp.domain.AbstractBaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TradeHandlerFactoryImpl implements TradeHandlerFactory {
    private final List<TradeHandler> tradeHandlers;

    @Autowired
    public TradeHandlerFactoryImpl(final List<TradeHandler> tradeHandlers) {
        this.tradeHandlers = List.copyOf(tradeHandlers);
    }

    @Override
    public <T extends AbstractBaseEntity> TradeHandler getTradeHandler(final T tradeHandler) {
        return this.tradeHandlers
                .stream()
                .filter(t -> t.getType().equals(tradeHandler.getClass().getTypeName()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
