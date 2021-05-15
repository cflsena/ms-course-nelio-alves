package br.com.course.ms.payroll.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor(staticName = "create")
@EqualsAndHashCode(of = "id")
public class Worker {
    private Long id;
    private String name;
    private BigDecimal dailyIncome;
}
