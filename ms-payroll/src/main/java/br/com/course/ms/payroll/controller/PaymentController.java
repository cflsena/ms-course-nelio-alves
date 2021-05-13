package br.com.course.ms.payroll.controller;

import br.com.course.ms.payroll.domain.Payment;
import br.com.course.ms.payroll.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> payment(@PathVariable  Long workerId, @PathVariable int days){
        return ResponseEntity.ok(this.paymentService.getPayment(workerId, days));
    }

}
