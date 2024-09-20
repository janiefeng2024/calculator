package main.config;

import main.operations.*;
import main.operations.Operation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CalculatorConfig {

    @Bean
    public Map<main.operations.Operation, OperationMethod> operationStrategies(AddOperation addOperation,
                                                                               SubtractOperation subtractOperation,
                                                                               MultiplyOperation multiplyOperation,
                                                                               DivideOperation divideOperation) {
        Map<Operation, OperationMethod> operationMap = new HashMap<>();
        operationMap.put(Operation.ADD, addOperation);
        operationMap.put(Operation.SUBTRACT, subtractOperation);
        operationMap.put(Operation.MULTIPLY, multiplyOperation);
        operationMap.put(Operation.DIVIDE, divideOperation);

        return operationMap;
    }
}
