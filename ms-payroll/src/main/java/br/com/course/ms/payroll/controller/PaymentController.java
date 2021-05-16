package br.com.course.ms.payroll.controller;

import br.com.course.ms.payroll.domain.Payment;
import br.com.course.ms.payroll.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @HystrixCommand(fallbackMethod = "alternativePayment")
    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> payment(@PathVariable  Long workerId, @PathVariable int days){
        return ResponseEntity.ok(this.paymentService.getPayment(workerId, days));
    }

    /*
     * This is a alternative method for circuit break cases
     */
    public ResponseEntity<Payment> alternativePayment(Long workerId, int days){
        return ResponseEntity.ok(Payment.create("Brann", new BigDecimal(400), days));
    }

}
