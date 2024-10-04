package test;

import main.Calculator;
import main.operations.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CalculatorTest {

    @Mock
    private AddOperation addOperation;

    @Mock
    private SubtractOperation subtractOperation;

    @Mock
    private MultiplyOperation multiplyOperation;

    @Mock
    private DivideOperation divideOperation;

    private Map<Operation, OperationMethod> operationMap;

    @InjectMocks
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        operationMap = new HashMap<>();
        operationMap.put(Operation.ADD, addOperation);
        operationMap.put(Operation.SUBTRACT, subtractOperation);
        operationMap.put(Operation.MULTIPLY, multiplyOperation);
        operationMap.put(Operation.DIVIDE, divideOperation);

        // Initialize calculator
        calculator = new Calculator(12, operationMap);
    }



    @Test
    public void testAddition() {
        when(addOperation.apply(12, 3)).thenReturn(15);
        calculator.chain(Operation.ADD, 3);
        Number result = calculator.getResult();
        assertEquals(15, result.doubleValue(), "Addition operation failed");
    }

    @Test
    public void testSubtraction() {
        when(subtractOperation.apply(12, 2)).thenReturn(10);
        calculator.chain(Operation.SUBTRACT, 2);
        Number result = calculator.getResult();
        assertEquals(10, result.doubleValue());
    }

    @Test
    public void testMultiplication() {
        when(multiplyOperation.apply(12, 3)).thenReturn(36);
        calculator.chain(Operation.MULTIPLY, 3);
        Number result = calculator.getResult();
        assertEquals(36, result.doubleValue());
    }

    @Test
    public void testDivision() {
        when(divideOperation.apply(12, 3)).thenReturn(4);
        calculator.chain(Operation.DIVIDE, 3);
        Number result = calculator.getResult();
        assertEquals(4, result.doubleValue(), "Division operation failed");
    }

    @Test
    public void testChainedOperations() {
        when(addOperation.apply(12, 3)).thenReturn(15);
        when(subtractOperation.apply(15, 4)).thenReturn(11);
        calculator.chain(Operation.ADD, 3)
                .chain(Operation.SUBTRACT, 4);
        Number result = calculator.getResult();
        assertEquals(11, result.doubleValue(), "Chaining operations failed");
    }
}
