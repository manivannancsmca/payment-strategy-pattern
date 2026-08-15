package com.payment.strategy.strategy;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.payment.strategy.dto.PaymentRequest;
import com.payment.strategy.dto.PaymentResponse;
import com.payment.strategy.model.PaymentProvider;

@Component
public class PaypalPaymentStrategy implements PaymentStrategy {

    @Override
    public PaymentProvider getProvider() {
        return PaymentProvider.PAYPAL;
    }

    @Override
    public PaymentResponse processPayment(PaymentRequest request) {
        System.out.println(
                "Calling PayPal API..."
        );

        String paymentId =
                "PAYPAL-" + UUID.randomUUID();

        return new PaymentResponse(
                request.orderId(),
                PaymentProvider.PAYPAL,
                paymentId,
                "SUCCESS",
                "PayPal payment successful"
        );
    }

}
