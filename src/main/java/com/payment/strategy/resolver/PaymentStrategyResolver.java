package com.payment.strategy.resolver;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.payment.strategy.exception.UnsupportedPaymentProviderException;
import com.payment.strategy.model.PaymentProvider;
import com.payment.strategy.strategy.PaymentStrategy;

@Component
public class PaymentStrategyResolver {

    private final Map<PaymentProvider, PaymentStrategy> strategyMap;

    public PaymentStrategyResolver(List<PaymentStrategy> strategies) {
        this.strategyMap = new EnumMap<>(PaymentProvider.class);

        for (PaymentStrategy strategy : strategies) {
            PaymentProvider provider = strategy.getProvider();

            strategyMap.put(provider, strategy);
        }

    }

    public PaymentStrategy resolve(PaymentProvider provider) {

       PaymentStrategy strategy = strategyMap.get(provider);

       if (strategy == null) {
            throw new UnsupportedPaymentProviderException(
                    "No payment strategy found for: "
                            + provider
            );
        }

        return strategy;
    }

}
