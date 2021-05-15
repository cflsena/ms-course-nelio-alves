package br.com.course.ms.payroll.service;

import br.com.course.ms.payroll.client.WorkerFeignClient;
import br.com.course.ms.payroll.domain.Payment;
import br.com.course.ms.payroll.domain.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, int days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return Payment.create(worker.getName(), worker.getDailyIncome(), days);
    }

}
