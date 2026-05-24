package labs.lab_5.advanced;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertSame;

/*
 * Notite:
 * - fiecare metoda are test separat;
 * - testele parametrizate acopera mai multe intrari;
 * - cazurile cu 0 si null documenteaza comportamentul actual.
 */
class NewIntCalculatorTest {
    @Test
    void defaultConstructorInitializesStateWithZero() {
        NewIntCalculator calculator = new NewIntCalculator();
        Object result = calculator.result();
        assertInstanceOf(Integer.class, result);
        assertEquals(0, result);
    }

    @Test
    void constructorWithStateKeepsProvidedInitialValue() {
        NewIntCalculator calculator = new NewIntCalculator(7);
        Object result = calculator.result();
        assertEquals(7, result);
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 15",
            "-4, 9, 5",
            "0, 0, 0"
    })
    void addUpdatesStateForDifferentInputs(int initialState, int value, int expected) {
        NewIntCalculator calculator = new NewIntCalculator(initialState);
        NewIntCalculator sameCalculator = calculator.add(value);
        assertSame(calculator, sameCalculator);
        assertEquals(expected, calculator.result());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 3, 7",
            "-4, -6, 2",
            "0, 0, 0"
    })
    void subtractUpdatesStateForDifferentInputs(int initialState, int value, int expected) {
        NewIntCalculator calculator = new NewIntCalculator(initialState);
        NewIntCalculator sameCalculator = calculator.subtract(value);
        assertSame(calculator, sameCalculator);
        assertEquals(expected, calculator.result());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 3, 30",
            "-4, -2, 8",
            "5, 0, 0"
    })
    void multiplyUpdatesStateForDifferentInputs(int initialState, int value, int expected) {
        NewIntCalculator calculator = new NewIntCalculator(initialState);
        NewIntCalculator sameCalculator = calculator.multiply(value);
        assertSame(calculator, sameCalculator);
        assertEquals(expected, calculator.result());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 2, 5",
            "-9, 3, -3",
            "0, 5, 0"
    })
    void divideUpdatesStateForDifferentInputs(int initialState, int value, int expected) {
        NewIntCalculator calculator = new NewIntCalculator(initialState);

        NewIntCalculator sameCalculator = calculator.divide(value);

        assertSame(calculator, sameCalculator);
        assertEquals(expected, calculator.result());
    }

    @Test
    void clearResetsStateToZero() {
        NewIntCalculator calculator = new NewIntCalculator(42);
        ACalculator sameCalculator = calculator.clear();
        assertSame(calculator, sameCalculator);
        assertEquals(0, calculator.result());
    }

    @Test
    void initResetsStateToZero() {
        NewIntCalculator calculator = new NewIntCalculator(42);
        calculator.init();
        assertEquals(0, calculator.result());
    }

    @Test
    void chainedOperationsReturnExpectedResult() {
        NewIntCalculator calculator = new NewIntCalculator(10);
        Object result = calculator.add(5).subtract(3).multiply(2).divide(3).result();
        assertEquals(8, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 8})
    void multiplyAcceptsZeroAndOtherValuesWithoutThrowing(int value) {
        NewIntCalculator calculator = new NewIntCalculator(5);
        assertDoesNotThrow(() -> calculator.multiply(value));
    }

    @Test
    void divideByZeroThrowsArithmeticException() {
        NewIntCalculator calculator = new NewIntCalculator(5);

        assertThrows(ArithmeticException.class, () -> calculator.divide(0));
    }

    @ParameterizedTest
    @NullSource
    void addThrowsNullPointerExceptionForNullValue(Integer value) {
        NewIntCalculator calculator = new NewIntCalculator(5);
        assertThrows(NullPointerException.class, () -> calculator.add(value));
    }

    @ParameterizedTest
    @NullSource
    void subtractThrowsNullPointerExceptionForNullValue(Integer value) {
        NewIntCalculator calculator = new NewIntCalculator(5);
        assertThrows(NullPointerException.class, () -> calculator.subtract(value));
    }

    @ParameterizedTest
    @NullSource
    void multiplyThrowsNullPointerExceptionForNullValue(Integer value) {
        NewIntCalculator calculator = new NewIntCalculator(5);
        assertThrows(NullPointerException.class, () -> calculator.multiply(value));
    }

    @ParameterizedTest
    @NullSource
    void divideThrowsNullPointerExceptionForNullValue(Integer value) {
        NewIntCalculator calculator = new NewIntCalculator(5);

        assertThrows(NullPointerException.class, () -> calculator.divide(value));
    }
}
