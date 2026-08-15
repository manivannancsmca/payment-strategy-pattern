package com.payment.strategy.strategy;

import com.payment.strategy.dto.PaymentRequest;
import com.payment.strategy.dto.PaymentResponse;
import com.payment.strategy.model.PaymentProvider;

public interface PaymentStrategy {

    PaymentProvider getProvider();

    PaymentResponse processPayment(
            PaymentRequest request
    );
}
