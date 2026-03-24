package student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CatalogStudenti {
    private final Set<Student> studenti = new LinkedHashSet<>();

    public void adaugaStudent(Student student) {
        studenti.add(student);
    }

    public void adaugaStudenti(Collection<Student> studentiNoi) {
        studenti.addAll(studentiNoi);
    }

    public boolean contineStudent(Student student) {
        return studenti.contains(student);
    }

    public List<Student> getStudenti() {
        return new ArrayList<>(studenti);
    }

    public void afiseazaCatalog() {
        for (Student student : studenti) {
            System.out.println(student);
        }
    }
}
