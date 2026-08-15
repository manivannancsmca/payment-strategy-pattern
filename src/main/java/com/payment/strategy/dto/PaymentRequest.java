package com.payment.strategy.dto;

import java.math.BigDecimal;

import com.payment.strategy.model.PaymentProvider;

public record PaymentRequest(

        Long orderId,

        PaymentProvider provider,

        BigDecimal amount,

        String currency

) {
}
