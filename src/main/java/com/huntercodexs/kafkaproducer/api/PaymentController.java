package com.huntercodexs.kafkaproducer.api;

import com.huntercodexs.kafkaproducer.record.PaymentRecord;
import com.huntercodexs.kafkaproducer.service.PaymentRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class PaymentController {

    @Autowired
    PaymentRequestProducer paymentRequestProducer;

    @PostMapping(path = "/payment")
    public String pay(@RequestBody PaymentRecord paymentRecord) {
        return paymentRequestProducer.send(paymentRecord);
    }

}
