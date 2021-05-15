package br.com.course.ms.payroll.service;

import br.com.course.ms.payroll.domain.Payment;
import br.com.course.ms.payroll.domain.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    private final RestTemplate restTemplate;

    public Payment getPayment(Long workerId, int days) {
        Map<String, String> uriVariable = new HashMap<>();
        uriVariable.put("id", "" + workerId);
        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariable);
        return Payment.create(worker.getName(), worker.getDailyIncome(), days);
    }

}
