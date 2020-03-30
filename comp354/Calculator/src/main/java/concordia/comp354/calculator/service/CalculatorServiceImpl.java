package concordia.comp354.calculator.service;

import concordia.comp354.calculator.error.BusinessException;
import concordia.comp354.calculator.error.EmBusinessError;
import concordia.comp354.calculator.utils.Operator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/05/17
 **/

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private Stack<Double> nums;
    private Stack<Operator> opes;
    private double tempNum;
    private Operator tempOpe;

    public static final double E = 2.7182818284590452354;
    public static final double PI = 3.14159265358979323846;

    @Override
    public String equal(String expression) {
        double resolve = resolve(expression);
        return String.valueOf(resolve);
    }

    @Override
    public String sin(BigDecimal operand) {
        double doubleValue = operand.doubleValue();
        double sin = Math.sin(doubleValue);
        return String.valueOf(sin);
    }

    /**
     * @author Bowen Yang
     * @param operand
     * @return
     */
    @Override
    public String cos(BigDecimal operand) {
        double x = operand.doubleValue();
        if (x <= Double.NEGATIVE_INFINITY || x >= Double.POSITIVE_INFINITY) {
            return String.valueOf(Double.NaN);
        }
        // Any negative angle can be brought back
        // to it's equivalent positive angle
        if (x < 0) {
            x = -x;
        }
        // Sine is a periodic function with period = 2*PI
        x %= 360;
        // create my own PI
        final double PI = 3.14159265358979323846;
        x = x * PI / 180;
        // Calculate cos(a)
        // Set precision to fit your needs.
        // Note that 171! > Double.MAX_VALUE, so
        // don't set PRECISION to anything greater
        // than 84
        final int PRECISION = 50;
        double temp = 1;
        double sign = 1, fact = 1,
                pow = 1;
        for (int i = 1; i <= PRECISION; i++) {
            //temp += Math.pow(-1, i) * (Math.pow(a, 2 * i ) / factorial(2 * i ));
            sign = sign * -1;
            fact = fact * (2 * i - 1) * (2 * i);
            pow = pow * x * x;
            temp = temp + sign * pow / fact;
        }
        // Set precision
        if ((temp < 0.000000000000001 && temp > 0)||(temp < 0 && temp > -0.000000000000001)){
            temp = 0;
        }
        return String.valueOf(temp);
    }

    @Override
    public String tan(BigDecimal operand) {
        double doubleValue = operand.doubleValue();
        double tan = Math.tan(doubleValue);
        return String.valueOf(tan);
    }

    @Override
    public String tenPower(BigDecimal operand) {
        double x = operand.doubleValue();
        double result = 0;
        final double logTen = 2.3025850929940456840179914546843642076011014886287729;
        if (x >= 0) {
            x *= logTen;
            double tempValue = 1;
            for (double i = 1; tempValue > 0; i += 1) {
                result += tempValue;
                tempValue *= x;
                tempValue /= i;
            }
        } else {
            x *= -logTen;
            double tempValue = 1;
            for (double i = 1; tempValue > 0; i += 1) {
                result += tempValue;
                tempValue *= x;
                tempValue /= i;
            }
            result = 1/result;
        }
        return String.valueOf(result);
    }

    @Override
    public String ln(BigDecimal operand) {
        double doubleValue = operand.doubleValue();
        double ln = Math.log(doubleValue);
        return String.valueOf(ln);
    }

    @Override
    public String log(BigDecimal operand) {
        double x = operand.doubleValue();
        // if argument is less than or equal to 0, the calculator should display
        // "Error!".
        if (x <= 0) {
            System.err.println("Error!");
            System.exit(0);
        }

        // log10(1) = 0
        // log10(10) = 1
        if (x == 1)
            return "0.0";
        if (x == 10)
            return "1.0";

        final double log10 = 2.302585092994046;
        double a = 0;
        double fraction;
        double result = 0;
        double temp = 1;

        // if 0 < x < 1,
        // according to Taylor series,
        // ln (1+x)/(1-x) = 2(x + (x^3)/3 + (x^5)/5 + ...)

        // 0 < x < 1 or x > 1
        while (x > 1) {
            x /= 10.0;
            a++;
        }
        fraction = (x - 1) / (x + 1);
        temp = fraction;
        for (int i = 0; i < 50; i++) {
            result += temp / (2 * i + 1);
            temp = temp * fraction * fraction;
        }
        result *= 2;
        return String.valueOf(a + result / log10);
    }

    // 沈吉：a function for computing e^x
    public String exp (BigDecimal operand) {
        double x = operand.doubleValue();
        //double can store max 16 decimals.
        final double e = 2.71828182845904523;
        int n = (int)x;

        //the exponent in Taylor series
        double exp = x - n;
        if(x == 0){
            return "1.0";
        } else {
            double currentTerm = 1.0;
            double series = 1.0;
            for (int i = 1; i < 30; i++) {
                currentTerm = currentTerm * exp / i;
                series += currentTerm;
            }
            if(x == 1) {
                return String.valueOf(e);
            } else if (x == -1){
                return String.valueOf(1.0/e);
            } else if (x > -1 && x < 1){ //high accuracy with only series when |x| < 1
                return String.valueOf(series);
            } else if (x > 1) { //e^x = e^n * e^exp when |x| > 1
                double result = 1.0;
                for (int i = 0; i < n; i++){
                    result *= e;
                }
                return String.valueOf(result * series);
            } else { //when x < -1
                double result = 1.0;
                for (int i = 0; i < -n; i++) {
                    result *= 1.0/e;
                }
                return String.valueOf(result * series);
            }
        }
    }

    @Override
    /**
    *    Edited by Jixuan Li  31 May 2019
    *    Add the non predefined sqrt method.
    */
    public String sqrt(BigDecimal operand) throws BusinessException {

        double input = operand.doubleValue();
        if (input < 0) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,
                    "The square root operation is only valid for non-negative value");
        }
        double guess = input / 2;
        double difference = guess * guess - input;
        if (difference < 0) {
            difference = -difference;
        }
        while ( difference > 0.00000000000001 ) {
            guess = ( guess + input / guess ) / 2;
            difference = guess * guess - input;
            if (difference < 0) {
                difference = -difference;
            }
        }
        return String.valueOf(guess);
    }

    @Override
    public String sinh(BigDecimal operand) {
        double x = operand.doubleValue();
        double exp1 = expForHyperbolic(x);
        double exp2 = expForHyperbolic(-x);
        double sinh = ( exp1 - exp2 ) / 2;
        return String.valueOf(sinh);
    }

    @Override
    public String cosh(BigDecimal operand) {
        double x = operand.doubleValue();
        double exp1 = expForHyperbolic(x);
        double exp2 = expForHyperbolic(-x);
        double cosh = ( exp1 + exp2 ) / 2;
        return String.valueOf(cosh);
    }

    @Override
    public String tanh(BigDecimal operand) {
        double x = operand.doubleValue();
        double exp1 = expForHyperbolic(x);
        double exp2 = expForHyperbolic(-x);
        double tanh = (exp1 - exp2) / (exp1 + exp2);
        return String.valueOf(tanh);
    }

    private double expForHyperbolic(double x){
        double sum = 1;
        for (int i = 50 - 1; i > 0; --i ){
            sum = 1 + x * sum / i;
        }
        return sum;
    }

    @Override
    public String square(BigDecimal operand) {
        double doubleValue = operand.doubleValue();
        double square = doubleValue * doubleValue;
        return String.valueOf(square);
    }

    @Override
    public String cube(BigDecimal operand) {
        double doubleValue = operand.doubleValue();
        double cube = doubleValue * doubleValue * doubleValue;
        return String.valueOf(cube);
    }

    @Override
    public String factorial(BigDecimal operand) {
        int intValueExact = operand.intValueExact();
        int result = 1;
        for (int i = 1; i <= intValueExact; i++) {
            result = result * i;
        }
        return String.valueOf(result);
    }

    private double resolve(String formula){
        while (formula.contains("(")) {
            formula = findSubFormula(formula);
        }
        nums = new Stack<>();
        opes = new Stack<>();
        formula = formula.replaceAll("--", "");
        formula = formula + "$";
        String regExp = "(-*\\d+\\.?\\d*)\\s*(\\D)\\s*";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(formula);
        boolean firstIteration = true;
        while (matcher.find()){
            tempNum = Double.parseDouble(matcher.group(1));
            tempOpe = new Operator(matcher.group(2).charAt(0)) ;
            if ( firstIteration || tempOpe.compareTo(opes.peek()) > 0){
                pushBoth();
            } else if (tempOpe.compareTo(opes.peek()) <= 0) {
                while (!nums.empty() && !opes.empty() && tempOpe.compareTo(opes.peek()) <= 0){
                    tempNum = Operator.calculate(nums.peek(), tempNum, opes.peek().getSymbol());
                    popBoth();
                }
                pushBoth();
            }
            firstIteration = false;
        }
        return nums.peek();
    }

    private String findSubFormula(String formula){
        if (formula.contains("(")){
            String subFormula;
            int start = formula.indexOf("(");
            int end = findClosedParenthesis(formula);
            subFormula = formula.substring(start+1, end);
            formula = formula.substring(0, start) + resolve(subFormula)
                    + formula.substring(end+1);
        }
        return formula;
    }

    private void pushBoth(){
        nums.push(tempNum);
        opes.push(tempOpe);
    }

    private void popBoth(){
        nums.pop();
        opes.pop();
    }

    private int findClosedParenthesis(String expression){
        Stack<Character> symbol = new Stack<>();
        symbol.push('(');
        int index = expression.indexOf("(");
        while (!symbol.empty()){
            index++;
            if (expression.charAt(index) == '('){
                symbol.push('(');
            } else if (expression.charAt(index) == ')') {
                symbol.pop();
            }
        }
        return index;
    }
}
