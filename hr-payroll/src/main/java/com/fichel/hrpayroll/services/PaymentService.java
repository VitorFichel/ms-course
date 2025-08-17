package com.fichel.hrpayroll.services;

import com.fichel.hrpayroll.entities.Payment;
import com.fichel.hrpayroll.entities.Worker;
import com.fichel.hrpayroll.feignclients.WorkerFeignClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClients workerFeignClients;

    public Payment getPayment(long id, int days) {
        Worker worker = workerFeignClients.findById(id).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
