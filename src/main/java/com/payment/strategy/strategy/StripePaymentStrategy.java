package com.payment.strategy.strategy;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.payment.strategy.dto.PaymentRequest;
import com.payment.strategy.dto.PaymentResponse;
import com.payment.strategy.model.PaymentProvider;

@Component
public class StripePaymentStrategy implements PaymentStrategy {

    @Override
    public PaymentProvider getProvider() {
         return PaymentProvider.STRIPE;
    }

    @Override
    public PaymentResponse processPayment(PaymentRequest request) {
        System.out.println(
                "Calling Stripe API..."
        );

        String paymentId =
                "STRIPE-" + UUID.randomUUID();

        return new PaymentResponse(
                request.orderId(),
                PaymentProvider.STRIPE,
                paymentId,
                "SUCCESS",
                "Stripe payment successful"
        );
    }

}
