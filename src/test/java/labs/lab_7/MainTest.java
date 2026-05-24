package labs.lab_7;

import org.junit.jupiter.api.Test;
import student.model.Student;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class MainTest {
    @Test
    void schimbaFormatiaReturnsNewStudentAndKeepsOriginalUnchanged() {
        Student student = new Student(1, "Ana", "Popescu", "TI 211");

        Student mutat = Main.schimbaFormatia(student, "TI 211_2");

        assertNotSame(student, mutat);
        assertEquals("TI 211", student.getFormatieDeStudiu());
        assertEquals("TI 211_2", mutat.getFormatieDeStudiu());
        assertEquals(student.getNumarMatricol(), mutat.getNumarMatricol());
        assertEquals(student.getPrenume(), mutat.getPrenume());
        assertEquals(student.getNume(), mutat.getNume());
    }

    @Test
    void imparteInDouaFormatiiSplitsOddSetWithFirstGroupLargerByOne() {
        Set<Student> studenti = new LinkedHashSet<>();
        studenti.add(new Student(1, "Ana", "Popescu", "TI 211"));
        studenti.add(new Student(2, "Bogdan", "Ionescu", "TI 211"));
        studenti.add(new Student(3, "Carmen", "Stan", "TI 211"));
        studenti.add(new Student(4, "Dan", "Marin", "TI 211"));
        studenti.add(new Student(5, "Elena", "Vasile", "TI 211"));

        Set<Student> rezultat = Main.imparteInDouaFormatii(studenti, "TI 211_1", "TI 211_2");

        assertEquals(5, rezultat.size());
        assertEquals(3, rezultat.stream()
                .filter(student -> student.getFormatieDeStudiu().equals("TI 211_1"))
                .count());
        assertEquals(2, rezultat.stream()
                .filter(student -> student.getFormatieDeStudiu().equals("TI 211_2"))
                .count());
    }

    @Test
    void studentDoesNotExposeSetters() {
        for (Method method : Student.class.getDeclaredMethods()) {
            assertFalse(
                    Modifier.isPublic(method.getModifiers()) && method.getName().startsWith("set"),
                    "Student should not expose public setters: " + method.getName()
            );
        }
    }
}
