package student.app;

import org.junit.jupiter.api.Test;
import student.model.StudentBursier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AplicatieCuBursaTest {
    @Test
    void sorteazaOrdersStudentsByStudyGroupNameSurnameGradeAndScholarship() {
        AplicatieCuBursa aplicatie = new AplicatieCuBursa();
        List<StudentBursier> studenti = new ArrayList<>();

        studenti.add(new StudentBursier(5, "Ana", "Ionescu", "TI131/2", 9.10, 700.0));
        studenti.add(new StudentBursier(4, "Bogdan", "Ionescu", "ISM141/1", 9.70, 600.0));
        studenti.add(new StudentBursier(3, "Ana", "Ionescu", "TI131/1", 9.50, 500.0));
        studenti.add(new StudentBursier(2, "Ana", "Ionescu", "TI131/1", 9.50, 800.0));
        studenti.add(new StudentBursier(1, "Ana", "Georgescu", "TI131/1", 8.50, 400.0));

        List<StudentBursier> rezultat = aplicatie.sorteaza(studenti);

        assertEquals(List.of(
                studenti.get(1),
                studenti.get(4),
                studenti.get(2),
                studenti.get(3),
                studenti.get(0)
        ), rezultat);
    }
}
