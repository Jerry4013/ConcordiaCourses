package concordia.comp354.calculator.controller;

import concordia.comp354.calculator.CommonReturnType;
import concordia.comp354.calculator.error.BusinessException;
import concordia.comp354.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/17
 **/

@Controller
@RequestMapping
@CrossOrigin(origins = {"*"}, allowCredentials = "true")
public class CalculatorController extends BaseController{

    @GetMapping
    public String home(){
        return "index.html";
    }

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping(value = "/equal")
    @ResponseBody
    public CommonReturnType equal(@RequestParam(name = "expression")String expression){
        String result = calculatorService.equal(expression);
        return CommonReturnType.create(result);
    }

    @GetMapping(value = "/square")
    @ResponseBody
    public CommonReturnType square(@RequestParam(name = "operand")BigDecimal operand){
        String result = calculatorService.square(operand);
        return CommonReturnType.create(result);
    }

    @GetMapping(value = "/cube")
    @ResponseBody
    public CommonReturnType cube(@RequestParam(name = "operand")BigDecimal operand){
        String result = calculatorService.cube(operand);
        return CommonReturnType.create(result);
    }

    @GetMapping(value = "/sin")
    @ResponseBody
    public CommonReturnType sin(@RequestParam(name = "operand")BigDecimal operand){
        String result = calculatorService.sin(operand);
        return CommonReturnType.create(result);
    }

    @GetMapping(value = "/cos")
    @ResponseBody
    public CommonReturnType cos(@RequestParam(name = "operand")BigDecimal operand){
        String result = calculatorService.cos(operand);
        return CommonReturnType.create(result);
    }

    @GetMapping(value = "/tan")
    @ResponseBody
    public CommonReturnType tan(@RequestParam(name = "operand")BigDecimal operand){
        String result = calculatorService.tan(operand);
        return CommonReturnType.create(result);
    }

    @GetMapping(value = "/tenPower")
    @ResponseBody
    public CommonReturnType tenPower(@RequestParam(name = "operand")BigDecimal operand){
        String result = calculatorService.tenPower(operand);
        return CommonReturnType.create(result);
    }

    @GetMapping(value = "/ln")
    @ResponseBody
    public CommonReturnType ln(@RequestParam(name = "operand")BigDecimal operand){
        String result = calculatorService.ln(operand);
        return CommonReturnType.create(result);
    }

    @GetMapping(value = "/log")
    @ResponseBody
    public CommonReturnType log(@RequestParam(name = "operand")BigDecimal operand){
        String result = calculatorService.log(operand);
        return CommonReturnType.create(result);
    }

    @GetMapping(value = "/exp")
    @ResponseBody
    public CommonReturnType exp(@RequestParam(name = "operand")BigDecimal operand){
        String result = calculatorService.exp(operand);
        return CommonReturnType.create(result);
    }

    @GetMapping(value = "/sqrt")
    @ResponseBody
    public CommonReturnType sqrt(@RequestParam(name = "operand")BigDecimal operand) throws BusinessException {
        String result = calculatorService.sqrt(operand);
        return CommonReturnType.create(result);
    }

    @GetMapping(value = "/factorial")
    @ResponseBody
    public CommonReturnType factorial(@RequestParam(name = "operand")BigDecimal operand){
        String result = calculatorService.factorial(operand);
        return CommonReturnType.create(result);
    }

    @GetMapping(value = "/sinh")
    @ResponseBody
    public CommonReturnType sinh(@RequestParam(name = "operand")BigDecimal operand){
        String result = calculatorService.sinh(operand);
        return CommonReturnType.create(result);
    }

    @GetMapping(value = "/cosh")
    @ResponseBody
    public CommonReturnType cosh(@RequestParam(name = "operand")BigDecimal operand){
        String result = calculatorService.cosh(operand);
        return CommonReturnType.create(result);
    }

    @GetMapping(value = "/tanh")
    @ResponseBody
    public CommonReturnType tanh(@RequestParam(name = "operand")BigDecimal operand){
        String result = calculatorService.tanh(operand);
        return CommonReturnType.create(result);
    }


}
