package student.strategy.export;

/*
 * Lab history:
 * - Lab 10: strategie concreta pentru exportul studentilor in fisier text.
 */

import student.model.Student;
import student.strategy.IStudentiExport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StudentiInFisierText implements IStudentiExport {
    private final String fileName;

    public StudentiInFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        Path path = Paths.get(fileName);
        List<String> linii = new ArrayList<>();
        linii.add("numarMatricol;prenume;nume;formatieDeStudiu;nota");

        for (Student student : studenti) {
            linii.add(student.getNumarMatricol() + ";"
                    + student.getPrenume() + ";"
                    + student.getNume() + ";"
                    + student.getFormatieDeStudiu() + ";"
                    + String.format(Locale.US, "%.2f", student.getNota()));
        }

        try {
            Path parent = path.getParent();
            if (parent != null) {
                Files.createDirectories(parent);
            }
            Files.write(path, linii);
        } catch (IOException e) {
            System.out.println("Nu s-a putut scrie fisierul text: " + e.getMessage());
        }
    }
}
