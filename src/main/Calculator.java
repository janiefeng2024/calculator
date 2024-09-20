package main;

import main.exception.UnsupportedOperationException;
import main.operations.Operation;
import main.operations.OperationMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Calculator {
    private Number currentValue;

    private final Map<Operation, OperationMethod> operationMap;

    @Autowired
    public Calculator(Number initialValue, Map<Operation, OperationMethod> operationMap) {
        this.currentValue = initialValue;
        this.operationMap = operationMap;
    }

    //perform single operation
    public Number calculate(Operation operation, Number num1, Number num2){
        OperationMethod operationMethod = operationMap.get(operation);
        if(operationMethod == null){
            throw new UnsupportedOperationException("Operation method doesn't exists: "+ operation);
        }
        return operationMethod.apply(num1, num2);
    }

    //perform chain operation
    public Calculator chain(Operation operation, Number value){
        this.currentValue = calculate(operation, this.currentValue, value);
        return this;
    }
    public Number getResult() {
        return this.currentValue;
    }
}
