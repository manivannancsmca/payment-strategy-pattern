package com.payment.strategy.exception;

public class UnsupportedPaymentProviderException
        extends RuntimeException {

    public UnsupportedPaymentProviderException(
            String message) {

        super(message);
    }
}
