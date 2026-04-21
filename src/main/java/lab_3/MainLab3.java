package lab_3;

import student.Student;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MainLab3 {
    public static void main(String[] args) {
        TextFileProcessor textProcessor = new TextFileProcessor();
        StudentFileProcessor studentProcessor = new StudentFileProcessor();

        try {
            Path inputText = Paths.get("Inputs", "in.txt");
            Path outputText = Paths.get("Outputs", "out.txt");// cale
            List<String> lines = textProcessor.citesteLinii(inputText);

            String rezultatA = textProcessor.adaugaLinieNouaLaSfarsitDeLinie(lines);
            String rezultatB = textProcessor.adaugaLinieNouaDupaPunct(lines);

            System.out.println("Rezultatul pentru punctul a):");
            System.out.println(rezultatA);
            System.out.println("Rezultatul pentru punctul b):");
            System.out.println(rezultatB);

            textProcessor.scrieRezultat(outputText, textProcessor.construiesteContinutOut(rezultatA, rezultatB));

            Path inputStudenti = Paths.get("Inputs", "studenti_in.txt");
            Path outputStudenti = Paths.get("Outputs", "studenti_out.txt");
            Path outputStudentiSorted = Paths.get("Outputs", "studenti_out_sorted.txt");

            List<Student> studenti = studentProcessor.citesteStudenti(inputStudenti);
            System.out.println("Studentii cititi din fisier:");
            studentProcessor.afiseazaStudenti(studenti);

            studentProcessor.scrieStudenti(outputStudenti, studentProcessor.sorteazaDupaNume(studenti));
            studentProcessor.scrieStudenti(
                    outputStudentiSorted,
                    studentProcessor.sorteazaDupaFormatieSiNume(studenti)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
