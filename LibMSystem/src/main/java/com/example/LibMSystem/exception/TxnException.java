package com.example.LibMSystem.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

public class TxnException extends Exception{
    public TxnException(String msg) {
        super(msg);
    }
}
