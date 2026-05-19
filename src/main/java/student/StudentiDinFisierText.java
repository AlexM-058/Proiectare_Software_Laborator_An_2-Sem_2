package student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierText implements IStudentiImport {
    private final String fileName;

    public StudentiDinFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Student> doImport() {
        List<Student> studenti = new ArrayList<>();
        Path path = Paths.get(fileName);

        try {
            List<String> linii = Files.readAllLines(path);
            for (int i = 1; i < linii.size(); i++) {
                String linie = linii.get(i);
                if (linie.isBlank()) {
                    continue;
                }

                String[] valori = linie.split(";", -1);
                Student student = new Student(
                        Integer.parseInt(valori[0]),
                        valori[1],
                        valori[2],
                        valori[3],
                        Double.parseDouble(valori[4])
                );
                studenti.add(student);
            }
        } catch (IOException e) {
            System.out.println("Nu s-a putut citi fisierul text: " + e.getMessage());
        }

        return studenti;
    }
}
