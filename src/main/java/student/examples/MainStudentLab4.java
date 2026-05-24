package student.examples;

import labs.lab_3.StudentFileProcessor;
import student.model.CatalogStudenti;
import student.model.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainStudentLab4 {
    private static final Path STUDENTI_PATH = Paths.get("Inputs", "studenti_in.txt");
    private static final Path NOTE_PATH = Paths.get("Inputs", "note_anon.txt");

    public static void main(String[] args) {
        StudentFileProcessor studentProcessor = new StudentFileProcessor();
        CatalogStudenti catalog = new CatalogStudenti();

        try {
            catalog.adaugaStudenti(studentProcessor.citesteStudenti(STUDENTI_PATH));
            citesteSiAlocaNote(catalog, NOTE_PATH);
            catalog.afiseazaCatalog();

            float notaM = gasesteNota("Bianca", "Popescu", catalog.getStudentiMap());
            float notaN = gasesteNota("Ioan", "Mihalcea", catalog.getStudentiMap());

            System.out.println("Nota pentru Bianca Popescu: " + notaM);
            System.out.println("Nota pentru Ioan Mihalcea: " + notaN);
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public static float gasesteNota(String prenume, String nume, Map<Integer, Student> studentiMap) {
        Map<String, Student> studentiDupaNume = new HashMap<>();

        for (Student student : studentiMap.values()) {
            String cheie = student.getPrenume().trim() + "-" + student.getNume().trim();
            studentiDupaNume.put(cheie, student);
        }

        String cheieCautata = prenume.trim() + "-" + nume.trim();
        Student studentGasit = studentiDupaNume.get(cheieCautata);

        if (studentGasit == null) {
            return 0.0f;
        }

        return (float) studentGasit.getNota();
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
