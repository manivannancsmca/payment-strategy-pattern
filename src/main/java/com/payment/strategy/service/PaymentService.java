package com.payment.strategy.service;

import org.springframework.stereotype.Service;

import com.payment.strategy.dto.PaymentRequest;
import com.payment.strategy.dto.PaymentResponse;
import com.payment.strategy.resolver.PaymentStrategyResolver;
import com.payment.strategy.strategy.PaymentStrategy;

@Service
public class PaymentService {

    private final PaymentStrategyResolver strategyResolver;

    public PaymentService(
            PaymentStrategyResolver strategyResolver) {

        this.strategyResolver = strategyResolver;
    }

    public PaymentResponse processPayment(
            PaymentRequest request) {

        PaymentStrategy strategy = strategyResolver.resolve(request.provider());

         return strategy.processPayment(request);
    }

}
