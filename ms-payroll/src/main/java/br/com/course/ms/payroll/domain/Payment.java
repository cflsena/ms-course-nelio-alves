package br.com.course.ms.payroll.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor(staticName = "create")
public class Payment {

    private String name;
    private BigDecimal dailyIncome;
    private int days;

    public BigDecimal getTotal(){
        return this.dailyIncome.multiply(new BigDecimal(days));
    }
}
