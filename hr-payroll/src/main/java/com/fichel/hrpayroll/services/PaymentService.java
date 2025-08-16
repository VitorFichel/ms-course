package com.fichel.hrpayroll.services;

import com.fichel.hrpayroll.entities.Payment;
import com.fichel.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String WorkerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(long id, int days) {
        Map<String, String> uriVariables = new HashMap<String, String>();
        uriVariables.put("id", String.valueOf(id));
        Worker worker = restTemplate.getForObject(WorkerHost+"/workers/{id}", Worker.class, uriVariables);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
