package com.huntercodexs.kafkaproducer.api;

import com.huntercodexs.kafkaproducer.dto.PaymentDto;
import com.huntercodexs.kafkaproducer.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping(path = "/payment")
    public String pay(@RequestBody PaymentDto paymentDto) {
        return paymentService.paymentIntegration(paymentDto);
    }

}
