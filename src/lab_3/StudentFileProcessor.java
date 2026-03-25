package lab_3;

import student.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentFileProcessor {
    public List<Student> citesteStudenti(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        List<Student> studenti = new ArrayList<>();
        for (String line : lines) {
            if (line.isBlank()) {
                continue;
            }
            String[] campuri = line.split(",");
            if (campuri.length != 4) {
                throw new IllegalArgumentException("Linie invalida pentru student: " + line);
            }
            studenti.add(new Student(
                    Integer.parseInt(campuri[0].trim()),
                    campuri[1].trim(),
                    campuri[2].trim(),
                    campuri[3].trim()
            ));
        }
        return studenti;
    }

    public List<Student> sorteazaDupaNume(List<Student> studenti) {
        List<Student> rezultat = new ArrayList<>(studenti);

        rezultat.sort(Comparator.comparing(Student::getNume)
                .thenComparing(Student::getPrenume)
                .thenComparingInt(Student::getNumarMatricol));
        return rezultat;
    }

    public List<Student> sorteazaDupaFormatieSiNume(List<Student> studenti) {
        List<Student> rezultat = new ArrayList<>(studenti);
        rezultat.sort(Comparator.comparing(Student::getFormatieDeStudiu)
                .thenComparing(Student::getNume)
                .thenComparing(Student::getPrenume)
                .thenComparingInt(Student::getNumarMatricol));
        return rezultat;
    }

    public void afiseazaStudenti(List<Student> studenti) {
        for (Student student : studenti) {
            System.out.println(student);
        }
    }

    public void scrieStudenti(Path path, List<Student> studenti) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Student student : studenti) {
            lines.add(student.toCsvLine());
        }
        Files.write(path, lines);
    }
}
