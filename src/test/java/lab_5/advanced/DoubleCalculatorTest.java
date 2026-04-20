package lab_5.advanced;

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
 * Clasa de test pentru DoubleCalculator.
 *
 * Aici urmez aceeasi strategie ca la NewIntCalculator:
 * - constructorii sunt testati separat;
 * - fiecare operatie aritmetica are teste cu mai multe seturi de date;
 * - clear(), init() si result() au teste dedicate;
 * - sunt incluse si negative path tests pentru valori null.
 *
 * Diferenta importanta fata de varianta pe int:
 * - la DoubleCalculator verific si rotunjirea la doua zecimale,
 *   pentru ca metoda result() are logica proprie.
 */
class DoubleCalculatorTest {
    @Test
    void defaultConstructorInitializesStateWithZero() {
        // Pornim de la verificarea celei mai simple promisiuni: obiectul nou are starea 0.0.
        // arrange
        DoubleCalculator calculator = new DoubleCalculator();

        // act
        Double result = calculator.result();

        // assert
        assertEquals(0.0, result);
    }

    @Test
    void constructorWithStateKeepsProvidedInitialValue() {
        // Confirm ca valoarea initiala este pastrata si expusa de result().
        // arrange
        DoubleCalculator calculator = new DoubleCalculator(7.25);

        // act
        Double result = calculator.result();

        // assert
        assertEquals(7.25, result);
    }

    @ParameterizedTest
    @CsvSource({
            "10.0, 5.5, 15.5",
            "-4.25, 9.0, 4.75",
            "0.0, 0.0, 0.0"
    })
    void addUpdatesStateForDifferentInputs(double initialState, double value, double expected) {
        // Folosesc valori reale diferite pentru a demonstra ca metoda functioneaza in scenarii variate.
        // arrange
        DoubleCalculator calculator = new DoubleCalculator(initialState);

        // act
        DoubleCalculator sameCalculator = calculator.add(value);

        // assert
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
        // Structura ramane aceeasi, doar operatia testata se schimba.
        // arrange
        DoubleCalculator calculator = new DoubleCalculator(initialState);

        // act
        DoubleCalculator sameCalculator = calculator.subtract(value);

        // assert
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
        // Includ si cazul cu 0.0 pentru a acoperi o limita frecventa.
        // arrange
        DoubleCalculator calculator = new DoubleCalculator(initialState);

        // act
        DoubleCalculator sameCalculator = calculator.multiply(value);

        // assert
        assertSame(calculator, sameCalculator);
        assertEquals(expected, calculator.result());
    }

    @Test
    void resultRoundsValueToTwoDecimals() {
        // Acesta este testul cel mai important pentru comportamentul specific DoubleCalculator.
        // arrange
        DoubleCalculator calculator = new DoubleCalculator(10.0);

        // act
        Double result = calculator.subtract(3.333).result();

        // assert
        assertEquals(6.67, result);
    }

    @Test
    void clearResetsStateToZero() {
        // Testez comportamentul de resetare prin API-ul mostenit din ACalculator.
        // arrange
        DoubleCalculator calculator = new DoubleCalculator(42.5);

        // act
        ACalculator sameCalculator = calculator.clear();

        // assert
        assertSame(calculator, sameCalculator);
        assertEquals(0.0, calculator.result());
    }

    @Test
    void initResetsStateToZero() {
        // Test direct pe init(), pentru a separa clar responsabilitatile metodelor.
        // arrange
        DoubleCalculator calculator = new DoubleCalculator(42.5);

        // act
        calculator.init();

        // assert
        assertEquals(0.0, calculator.result());
    }

    @Test
    void chainedOperationsReturnExpectedRoundedResult() {
        // Scenariu compus: arata ca obiectul poate fi folosit fluent, in lant.
        // arrange
        DoubleCalculator calculator = new DoubleCalculator(10.0);

        // act
        Double result = calculator.add(5.5).subtract(3.3).multiply(2.2).result();

        // assert
        assertEquals(26.84, result);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -1.5, 8.25})
    void multiplyAcceptsZeroAndOtherValuesWithoutThrowing(double value) {
        // Negative path in sens de robustete: verific ca 0.0 nu produce o eroare neasteptata.
        // arrange
        DoubleCalculator calculator = new DoubleCalculator(5.0);

        // act + assert
        assertDoesNotThrow(() -> calculator.multiply(value));
    }

    @ParameterizedTest
    @NullSource
    void addThrowsNullPointerExceptionForNullValue(Double value) {
        // Pentru null documentam exceptia reala aruncata de implementarea curenta.
        // arrange
        DoubleCalculator calculator = new DoubleCalculator(5.0);

        // act + assert
        assertThrows(NullPointerException.class, () -> calculator.add(value));
    }

    @ParameterizedTest
    @NullSource
    void subtractThrowsNullPointerExceptionForNullValue(Double value) {
        // Astfel poti explica ce se intampla cand codul primeste o intrare nevalida.
        // arrange
        DoubleCalculator calculator = new DoubleCalculator(5.0);

        // act + assert
        assertThrows(NullPointerException.class, () -> calculator.subtract(value));
    }

    @ParameterizedTest
    @NullSource
    void multiplyThrowsNullPointerExceptionForNullValue(Double value) {
        // Testul fixeaza comportamentul existent si ajuta la discutii despre imbunatatiri viitoare.
        // arrange
        DoubleCalculator calculator = new DoubleCalculator(5.0);

        // act + assert
        assertThrows(NullPointerException.class, () -> calculator.multiply(value));
    }
}
