package com.huntercodexs.kafkaproducer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.huntercodexs.kafkaproducer.dto.PaymentDto;
import com.huntercodexs.kafkaproducer.message.PaymentRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRequestProducer paymentRequestProducer;

    public String paymentIntegration(PaymentDto paymentDto) {
        try {
            return paymentRequestProducer.send(paymentDto);
        } catch (JsonProcessingException e) {
            return "Error while payment processing: " + e.getMessage();
        }
    }
}
