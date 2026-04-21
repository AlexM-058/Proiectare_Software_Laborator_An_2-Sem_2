package student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatalogStudenti {
    private final Map<Integer, Student> studenti = new HashMap<>();

    public void adaugaStudent(Student student) {
        Student studentExistent = studenti.putIfAbsent(student.getNumarMatricol(), student);
        if (studentExistent != null) {
            throw new IllegalArgumentException(
                    "Numar matricol duplicat gasit in fisier: " + student.getNumarMatricol()
            );
        }
    }

    public void adaugaStudenti(Collection<Student> studentiNoi) {
        for (Student student : studentiNoi) {
            adaugaStudent(student);
        }
    }

    public Student getStudent(int numarMatricol) {
        return studenti.get(numarMatricol);
    }

    public void actualizeazaNota(int numarMatricol, double nota) {
        Student student = getStudent(numarMatricol);
        if (student == null) {
            throw new IllegalArgumentException(
                    "Nu exista student pentru numarul matricol: " + numarMatricol
            );
        }
        student.setNota(nota);
    }

    public List<Student> getStudenti() {
        return new ArrayList<>(studenti.values());
    }

    public Map<Integer, Student> getStudentiMap() {
        return Collections.unmodifiableMap(studenti);
    }

    public void afiseazaCatalog() {
        for (Map.Entry<Integer, Student> entry : studenti.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
