package concordia.comp354.calculator.service;

import concordia.comp354.calculator.error.BusinessException;

import java.math.BigDecimal;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/17
 **/

public interface CalculatorService {

    String equal(String expression);

    String sin(BigDecimal operand);

    String cos(BigDecimal operand);

    String tan(BigDecimal operand);

    String tenPower(BigDecimal operand);

    String ln(BigDecimal operand);

    String log(BigDecimal operand);

    String exp(BigDecimal operand);

    String sqrt(BigDecimal operand) throws BusinessException;

    String sinh(BigDecimal operand);

    String cosh(BigDecimal operand);

    String tanh(BigDecimal operand);

    String square(BigDecimal operand);

    String cube(BigDecimal operand);

    String factorial(BigDecimal operand);

}
