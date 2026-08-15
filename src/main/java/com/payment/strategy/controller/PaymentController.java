package com.payment.strategy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.payment.strategy.dto.PaymentRequest;
import com.payment.strategy.dto.PaymentResponse;
import com.payment.strategy.service.PaymentService;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(
            PaymentService paymentService) {

        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> processPayment(
            @RequestBody PaymentRequest request) {

        PaymentResponse response = paymentService.processPayment(request);

        return ResponseEntity.ok(response);
    }
}
