package com.huntercodexs.kafkaproducer.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huntercodexs.kafkaproducer.dto.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentRequestProducer {

    @Value("${topics.payment.request.topic}")
    private String paymentTopic;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String send(PaymentDto paymentDto) throws JsonProcessingException {
        String content = objectMapper.writeValueAsString(paymentDto);
        kafkaTemplate.send(paymentTopic, content);
        return "Payment sent successfully";
    }

}
