package concordia.comp354.calculator.service;

import concordia.comp354.calculator.error.BusinessException;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorServiceImplTest {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    public void equal() {
    }

    @Test
    public void sin() {
    }

    @Test
    public void cos() {
        String cos1 = calculatorService.cos(new BigDecimal(0));
        Assert.assertEquals("1.0", cos1);
        String cos2 = calculatorService.cos(new BigDecimal(48));
        Assert.assertThat(cos2, CoreMatchers.startsWith("0.669130606358858"));
    }

    @Test
    public void tan() {
    }

    @Test
    public void tenPower() {
        String tenPower1 = calculatorService.tenPower(new BigDecimal(2));
        Assert.assertEquals("100.0", tenPower1);
        String tenPower2 = calculatorService.tenPower(new BigDecimal(1.5));
        Assert.assertThat(tenPower2, CoreMatchers.startsWith("31.622776601683"));
    }

    @Test
    public void ln() {
    }

    @Test
    public void log() {
        String log1 = calculatorService.log(new BigDecimal(10));
        Assert.assertEquals("1.0", log1);
        String log2 = calculatorService.log(new BigDecimal(1.5));
        Assert.assertThat(log2, CoreMatchers.startsWith("0.17609125905568"));
    }

    //Shen Ji
    @Test
    public void exp() {
        String exp1 = calculatorService.exp(new BigDecimal(0));
        Assert.assertEquals("1.0", exp1);
        String exp2 = calculatorService.exp(new BigDecimal(1));
        Assert.assertThat(exp2, CoreMatchers.startsWith("2.718281828459045"));
    }

    //Jixuan
    @Test
    public void sqrt() {
        try {
            String sqrt1 = calculatorService.sqrt(new BigDecimal(9));
            Assert.assertEquals("3.0", sqrt1);
            String sqrt2 = calculatorService.sqrt(new BigDecimal(32));
            Assert.assertThat(sqrt2, CoreMatchers.startsWith("5.65685424949238"));
        } catch (BusinessException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void sinh() {
        String sinh1 = calculatorService.sinh(new BigDecimal(0));
        Assert.assertEquals("0.0", sinh1);
        String sinh2 = calculatorService.sinh(new BigDecimal(1));
        Assert.assertThat(sinh2, CoreMatchers.startsWith("1.175201193643801"));
    }

    @Test
    public void cosh() {
        String cosh1 = calculatorService.cosh(new BigDecimal(0));
        Assert.assertEquals("1.0", cosh1);
        String cosh2 = calculatorService.cosh(new BigDecimal(1));
        Assert.assertThat(cosh2, CoreMatchers.startsWith("1.543080634815243"));
    }

    @Test
    public void tanh() {
        String tanh1 = calculatorService.tanh(new BigDecimal(0));
        Assert.assertEquals("0.0", tanh1);
        String tanh2 = calculatorService.tanh(new BigDecimal(1));
        Assert.assertThat(tanh2, CoreMatchers.startsWith("0.761594155955764"));
    }

    @Test
    public void square() {
    }

    @Test
    public void cube() {
    }

    @Test
    public void factorial() {
    }
}