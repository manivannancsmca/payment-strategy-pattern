package com.payment.strategy.dto;

import com.payment.strategy.model.PaymentProvider;

public record PaymentResponse(

        Long orderId,

        PaymentProvider provider,

        String paymentId,

        String status,

        String message

) {
}
