package com.payment.strategy.strategy;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.payment.strategy.dto.PaymentRequest;
import com.payment.strategy.dto.PaymentResponse;
import com.payment.strategy.model.PaymentProvider;

@Component
public class RazorpayPaymentStrategy implements PaymentStrategy {

    @Override
    public PaymentProvider getProvider() {
       return PaymentProvider.RAZORPAY;
    }

    @Override
    public PaymentResponse processPayment(PaymentRequest request) {
       System.out.println(
                "Calling Razorpay API..."
        );

        String paymentId =
                "RZP-" + UUID.randomUUID();

        return new PaymentResponse(
                request.orderId(),
                PaymentProvider.RAZORPAY,
                paymentId,
                "SUCCESS",
                "Razorpay payment successful"
        );
    }

}
