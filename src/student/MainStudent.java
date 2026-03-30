package student;

import lab_3.StudentFileProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MainStudent {
    private static final Path STUDENTI_PATH = Paths.get("studenti_in.txt");
    private static final Path NOTE_PATH = Paths.get("src", "student", "note_anon.txt");

    public static void main(String[] args) {
        StudentFileProcessor studentProcessor = new StudentFileProcessor();
        CatalogStudenti catalog = new CatalogStudenti();

        try {
            catalog.adaugaStudenti(studentProcessor.citesteStudenti(STUDENTI_PATH));
            citesteSiAlocaNote(catalog, NOTE_PATH);
            catalog.afiseazaCatalog();
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private static void citesteSiAlocaNote(CatalogStudenti catalog, Path notePath) throws IOException {
        List<String> linii = Files.readAllLines(notePath);
        for (String linie : linii) {
            if (linie.isBlank()) {
                continue;
            }

            String[] campuri = linie.split(",");
            if (campuri.length != 2) {
                throw new IllegalArgumentException("Linie invalida pentru nota: " + linie);
            }

            int numarMatricol = Integer.parseInt(campuri[0].trim());
            double nota = Double.parseDouble(campuri[1].trim());
            catalog.actualizeazaNota(numarMatricol, nota);
        }
    }
}
