# Calculator Java Implementation

## Overview
This document outlines the implementation of a `Calculator` class in Java that supports basic arithmetic operations, operation chaining, extensibility, compatibility with IoC environments, error handling, and thorough testing.

## Requirements

1. **Operations**: Define an enum named `Operation` that includes basic arithmetic operations like `ADD`, `SUBTRACT`, `MULTIPLY`, and `DIVIDE`.

2. **Basic Calculation**: Implement a method `calculate(Operation op, Number num1, Number num2)` in the `Calculator` class that performs a single operation between two numbers and returns the result.

3. **Chaining Operations**: Implement a method that allows chaining multiple operations on a single value, enabling users to start with an initial value and perform a series of operations sequentially.

4. **Extensibility**: Design the `Calculator` class so that new operations can be added without modifying the existing class. This ensures compliance with the Open/Closed Principle.

5. **IoC Compatibility**: Ensure the design is compatible with an Inversion of Control (IoC) environment, allowing external management of dependencies and enabling easy testing and implementation swaps.

6. **Error Handling**: Handle invalid operations gracefully, such as division by zero or unsupported operations, by throwing appropriate exceptions.

7. **Testing**: Implement unit tests to verify the correctness of the solution, covering both normal and edge cases.

## Design

### 1. Enum for Operations
An `enum` is used to define basic operations, including addition, subtraction, multiplication, and division. This enum helps in keeping the operations encapsulated and easy to manage.

### 2. Basic Calculation
The `calculate` method is designed to handle basic arithmetic operations. It uses the `Operation` enum to determine which operation to perform on the two given numbers. The method includes handling of common errors, such as division by zero.

### 3. Chaining Operations
The `Calculator` class includes a method to allow chaining multiple operations on a single value. Starting with an initial value, users can perform a series of operations sequentially and retrieve the final result. This mimics the behavior of a traditional calculator.

### 4. Extensibility
To ensure that the calculator can be easily extended, new operations can be added without modifying the core `Calculator` class. This could be done through design patterns like Strategy or Command, allowing new operations to be implemented independently and integrated seamlessly.

### 5. IoC Compatibility
The `Calculator` class is designed to be compatible with IoC containers, such as Spring. This allows external management of dependencies and supports swapping out implementations of the operations for testing or other purposes.

### 6. Error Handling
The solution includes proper error handling for cases such as invalid operations and division by zero. It ensures that the user is informed of errors through appropriate exceptions like `UnsupportedOperationException` and `ArithmeticException`.

### 7. Testing
A suite of unit tests is implemented to ensure the correct behavior of the calculator. These tests cover normal operations (e.g., addition and multiplication), chaining of operations, as well as edge cases like division by zero or unsupported operations.

## Conclusion
The `Calculator` class is a flexible, extensible, and robust solution for performing basic arithmetic operations. It supports chaining, is compatible with IoC environments, handles errors effectively, and is thoroughly tested for both common and edge cases.