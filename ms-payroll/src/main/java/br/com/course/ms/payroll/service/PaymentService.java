package br.com.course.ms.payroll.service;

import br.com.course.ms.payroll.domain.Payment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, int days) {
        return Payment.create("Bob", new BigDecimal(200), days);
    }

}
