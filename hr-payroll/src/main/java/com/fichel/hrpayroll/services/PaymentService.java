package com.fichel.hrpayroll.services;

import com.fichel.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long id, int days) {
        return new Payment("Bob", 200.0, days);
    }

}
