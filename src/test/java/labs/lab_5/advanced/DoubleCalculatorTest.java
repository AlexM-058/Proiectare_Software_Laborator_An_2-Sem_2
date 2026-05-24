package labs.lab_5.advanced;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
 * Notite:
 * - operatiile sunt verificate cu mai multe valori;
 * - pastrez teste separate pentru rotunjire si resetare;
 * - testele cu 0 si null arata comportamentul actual.
 */
class DoubleCalculatorTest {
    @Test
    void defaultConstructorInitializesStateWithZero() {
        DoubleCalculator calculator = new DoubleCalculator();
        Double result = calculator.result();
        assertEquals(0.0, result);
    }

    @Test
    void constructorWithStateKeepsProvidedInitialValue() {
        DoubleCalculator calculator = new DoubleCalculator(7.25);
        Double result = calculator.result();
        assertEquals(7.25, result);
    }

    @ParameterizedTest
    @CsvSource({
            "10.0, 5.5, 15.5",
            "-4.25, 9.0, 4.75",
            "0.0, 0.0, 0.0"
    })
    void addUpdatesStateForDifferentInputs(double initialState, double value, double expected) {
        DoubleCalculator calculator = new DoubleCalculator(initialState);
        DoubleCalculator sameCalculator = calculator.add(value);
        assertSame(calculator, sameCalculator);
        assertEquals(expected, calculator.result());
    }

    @ParameterizedTest
    @CsvSource({
            "10.0, 3.25, 6.75",
            "-4.0, -6.5, 2.5",
            "0.0, 0.0, 0.0"
    })
    void subtractUpdatesStateForDifferentInputs(double initialState, double value, double expected) {
        DoubleCalculator calculator = new DoubleCalculator(initialState);
        DoubleCalculator sameCalculator = calculator.subtract(value);
        assertSame(calculator, sameCalculator);
        assertEquals(expected, calculator.result());
    }

    @ParameterizedTest
    @CsvSource({
            "10.0, 3.0, 30.0",
            "-4.5, -2.0, 9.0",
            "5.75, 0.0, 0.0"
    })
    void multiplyUpdatesStateForDifferentInputs(double initialState, double value, double expected) {
        DoubleCalculator calculator = new DoubleCalculator(initialState);
        DoubleCalculator sameCalculator = calculator.multiply(value);
        assertSame(calculator, sameCalculator);
        assertEquals(expected, calculator.result());
    }

    @ParameterizedTest
    @CsvSource({
            "10.0, 2.0, 5.0",
            "-9.0, 3.0, -3.0",
            "0.0, 5.0, 0.0"
    })
    void divideUpdatesStateForDifferentInputs(double initialState, double value, double expected) {
        DoubleCalculator calculator = new DoubleCalculator(initialState);

        DoubleCalculator sameCalculator = calculator.divide(value);

        assertSame(calculator, sameCalculator);
        assertEquals(expected, calculator.result());
    }

    @Test
    void resultRoundsValueToTwoDecimals() {
        DoubleCalculator calculator = new DoubleCalculator(10.0);
        Double result = calculator.subtract(3.333).result();
        assertEquals(6.67, result);
    }

    @Test
    void clearResetsStateToZero() {
        DoubleCalculator calculator = new DoubleCalculator(42.5);
        ACalculator sameCalculator = calculator.clear();
        assertSame(calculator, sameCalculator);
        assertEquals(0.0, calculator.result());
    }

    @Test
    void initResetsStateToZero() {
        DoubleCalculator calculator = new DoubleCalculator(42.5);
        calculator.init();
        assertEquals(0.0, calculator.result());
    }

    @Test
    void chainedOperationsReturnExpectedRoundedResult() {
        DoubleCalculator calculator = new DoubleCalculator(10.0);
        Double result = calculator.add(5.5).subtract(3.3).multiply(2.2).divide(3.0).result();
        assertEquals(8.95, result);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -1.5, 8.25})
    void multiplyAcceptsZeroAndOtherValuesWithoutThrowing(double value) {
        DoubleCalculator calculator = new DoubleCalculator(5.0);
        assertDoesNotThrow(() -> calculator.multiply(value));
    }

    @Test
    void divideByZeroReturnsInfinity() {
        DoubleCalculator calculator = new DoubleCalculator(5.0);

        Double result = calculator.divide(0.0).result();

        assertEquals(Double.POSITIVE_INFINITY, result);
    }

    @ParameterizedTest
    @NullSource
    void addThrowsNullPointerExceptionForNullValue(Double value) {
        DoubleCalculator calculator = new DoubleCalculator(5.0);
        assertThrows(NullPointerException.class, () -> calculator.add(value));
    }

    @ParameterizedTest
    @NullSource
    void subtractThrowsNullPointerExceptionForNullValue(Double value) {
        DoubleCalculator calculator = new DoubleCalculator(5.0);
        assertThrows(NullPointerException.class, () -> calculator.subtract(value));
    }

    @ParameterizedTest
    @NullSource
    void multiplyThrowsNullPointerExceptionForNullValue(Double value) {
        DoubleCalculator calculator = new DoubleCalculator(5.0);
        assertThrows(NullPointerException.class, () -> calculator.multiply(value));
    }

    @ParameterizedTest
    @NullSource
    void divideThrowsNullPointerExceptionForNullValue(Double value) {
        DoubleCalculator calculator = new DoubleCalculator(5.0);

        assertThrows(NullPointerException.class, () -> calculator.divide(value));
    }
}
