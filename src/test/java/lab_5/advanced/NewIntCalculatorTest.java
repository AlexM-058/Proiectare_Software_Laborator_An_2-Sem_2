package lab_5.advanced;

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
 * Clasa de test pentru NewIntCalculator din cerinta de laborator 6.
 *
 * Ideea de constructie a testelor:
 * - pentru fiecare metoda publica am ales cel putin un test dedicat;
 * - pentru operatiile aritmetice am folosit si teste parametrizate,
 *   ca sa verific mai multe seturi de date fara sa duplic acelasi cod;
 * - am separat cazurile normale de cazurile negative;
 * - fiecare test respecta structura Arrange - Act - Assert.
 *
 * Cum poti explica aceste teste:
 * - Arrange: pregatesc obiectul si datele de intrare;
 * - Act: execut metoda testata;
 * - Assert: verific daca rezultatul sau exceptia este cea asteptata.
 */
class NewIntCalculatorTest {
    @Test
    void defaultConstructorInitializesStateWithZero() {
        // Verific faptul ca varianta fara parametri porneste cu valoarea 0.
        // arrange
        NewIntCalculator calculator = new NewIntCalculator();

        // act
        Object result = calculator.result();

        // assert
        assertInstanceOf(Integer.class, result);
        assertEquals(0, result);
    }

    @Test
    void constructorWithStateKeepsProvidedInitialValue() {
        // Verific faptul ca un constructor cu stare explicita nu modifica valoarea primita.
        // arrange
        NewIntCalculator calculator = new NewIntCalculator(7);

        // act
        Object result = calculator.result();

        // assert
        assertEquals(7, result);
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 15",
            "-4, 9, 5",
            "0, 0, 0"
    })
    void addUpdatesStateForDifferentInputs(int initialState, int value, int expected) {
        // Test parametrizat: acelasi scenariu logic este verificat pe mai multe intrari.
        // arrange
        NewIntCalculator calculator = new NewIntCalculator(initialState);

        // act
        NewIntCalculator sameCalculator = calculator.add(value);

        // assert
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
        // Pentru subtract urmarim acelasi tip de verificare: stare initiala, operatie, rezultat final.
        // arrange
        NewIntCalculator calculator = new NewIntCalculator(initialState);

        // act
        NewIntCalculator sameCalculator = calculator.subtract(value);

        // assert
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
        // Aici includ si cazul cu 0 ca sa arat ce se intampla intr-o situatie limita valida.
        // arrange
        NewIntCalculator calculator = new NewIntCalculator(initialState);

        // act
        NewIntCalculator sameCalculator = calculator.multiply(value);

        // assert
        assertSame(calculator, sameCalculator);
        assertEquals(expected, calculator.result());
    }

    @Test
    void clearResetsStateToZero() {
        // clear() foloseste init(), deci trebuie sa readuca obiectul in starea initiala.
        // arrange
        NewIntCalculator calculator = new NewIntCalculator(42);

        // act
        ACalculator sameCalculator = calculator.clear();

        // assert
        assertSame(calculator, sameCalculator);
        assertEquals(0, calculator.result());
    }

    @Test
    void initResetsStateToZero() {
        // Test direct pentru init(), separat de clear(), fiindca este o metoda proprie a clasei.
        // arrange
        NewIntCalculator calculator = new NewIntCalculator(42);

        // act
        calculator.init();

        // assert
        assertEquals(0, calculator.result());
    }

    @Test
    void chainedOperationsReturnExpectedResult() {
        // Verific si scenariul real de folosire in lant: add -> subtract -> multiply.
        // arrange
        NewIntCalculator calculator = new NewIntCalculator(10);

        // act
        Object result = calculator.add(5).subtract(3).multiply(2).result();

        // assert
        assertEquals(24, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 8})
    void multiplyAcceptsZeroAndOtherValuesWithoutThrowing(int value) {
        // Caz limita: inmultirea cu 0 nu trebuie sa arunce exceptie in implementarea actuala.
        // arrange
        NewIntCalculator calculator = new NewIntCalculator(5);

        // act + assert
        assertDoesNotThrow(() -> calculator.multiply(value));
    }

    @ParameterizedTest
    @NullSource
    void addThrowsNullPointerExceptionForNullValue(Integer value) {
        // Caz negativ: documentez comportamentul real al codului cand primeste null.
        // arrange
        NewIntCalculator calculator = new NewIntCalculator(5);

        // act + assert
        assertThrows(NullPointerException.class, () -> calculator.add(value));
    }

    @ParameterizedTest
    @NullSource
    void subtractThrowsNullPointerExceptionForNullValue(Integer value) {
        // Testul nu spune cum "ar trebui ideal" sa fie, ci ce face codul acum.
        // arrange
        NewIntCalculator calculator = new NewIntCalculator(5);

        // act + assert
        assertThrows(NullPointerException.class, () -> calculator.subtract(value));
    }

    @ParameterizedTest
    @NullSource
    void multiplyThrowsNullPointerExceptionForNullValue(Integer value) {
        // Acest tip de test ajuta la discutia despre robustete si validarea intrarilor.
        // arrange
        NewIntCalculator calculator = new NewIntCalculator(5);

        // act + assert
        assertThrows(NullPointerException.class, () -> calculator.multiply(value));
    }
}
