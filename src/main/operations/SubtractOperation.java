package main.operations;
import org.springframework.stereotype.Component;

@Component
public class SubtractOperation implements OperationMethod {
    @Override
    public Number apply(Number num1, Number num2) {
        if (num2.doubleValue() == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return num1.doubleValue() - num2.doubleValue();
    }
}
