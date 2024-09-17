package com.huntercodexs.kafkaproducer.service;

import com.huntercodexs.kafkaproducer.record.PaymentRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentRequestProducer {

    @Value("${topics.payment.request.topic}")
    private String paymentTopic;

    @Autowired
    KafkaTemplate<String, PaymentRecord> kafkaTemplate;

    @SuppressWarnings("null")
    public String send(PaymentRecord paymentRecord) {
        kafkaTemplate.send(paymentTopic, 0, null, paymentRecord);
        return "Payment sent successfully";
    }

}
