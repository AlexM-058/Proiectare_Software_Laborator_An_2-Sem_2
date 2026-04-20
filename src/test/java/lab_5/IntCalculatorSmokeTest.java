package lab_5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Test de fum: confirma rapid ca infrastructura JUnit functioneaza
 * si ca putem testa o operatie simpla pe calculatorul de baza.
 *
 * Il poti explica astfel:
 * 1. Arrange - creez obiectul cu o stare initiala cunoscuta.
 * 2. Act - apelez metoda pe care vreau sa o verific.
 * 3. Assert - compar rezultatul obtinut cu valoarea asteptata.
 */
class IntCalculatorSmokeTest {
    @Test
    void addReturnsUpdatedResult() {
        IntCalculator calculator = new IntCalculator(10);

        int result = calculator.add(5).result();

        assertEquals(15, result);
    }
}
