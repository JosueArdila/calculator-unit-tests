package co.com.sofka.app.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class BasicCalculatorTest {

    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    @DisplayName("Testing sum: 1+1=2")
    public void sum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.sum(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    public void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing subtract: 5-3=2")
    public void subtract() {
        // Arrange
        Long number1 = 5L;
        Long number2 = 3L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.subtract(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several subtractions")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "0,    1,   -1",
            "5,    2,   3",
            "49,  51, -2",
            "100,  100, 0"
    })
    public void severalSubtractions(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.subtract(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing divide: 15/3=5")
    public void divide() {
        // Arrange
        Long number1 = 15L;
        Long number2 = 3L;
        Long expectedValue = 5L;

        // Act
        Long result = basicCalculator.divide(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @Test
    @DisplayName("Testing divide: 7/0=Can not divide by zero")
    public void divideByZero() {
        // Arrange
        Long number1 = 7L;
        Long number2 = 0L;
        Exception thrown;

        // Act
        thrown = assertThrows(ArithmeticException.class,
                () -> basicCalculator.divide(number1, number2));

        // Assert
        assertTrue(thrown.getMessage().equals("Can not divide by zero"));
    }

    @DisplayName("Testing several divisions")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "45,    5,   9",
            "4890,  978, 5",
            "-8,    -2,   4",
            "0,     100, 0"
    })
    public void severalDivisions(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.divide(first, second),
                () -> first + " / " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing multiply: 5*3=15")
    public void multiply() {
        // Arrange
        Long number1 = 5L;
        Long number2 = 3L;
        Long expectedValue = 15L;

        // Act
        Long result = basicCalculator.multiply(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several multiplications")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "13,    9,   117",
            "0,    -1,   0",
            "-8,    -2,   16",
            "100,     33417, 3341700"
    })
    public void severalMultiplications(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.multiply(first, second),
                () -> first + " * " + second + " should equal " + expectedResult);
    }

}
