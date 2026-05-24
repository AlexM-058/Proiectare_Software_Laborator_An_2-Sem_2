package labs.lab_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TextFileProcessor {
    public List<String> citesteLinii(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    public String adaugaLinieNouaLaSfarsitDeLinie(List<String> lines) {
        String separator = System.lineSeparator();
        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            builder.append(line).append(separator).append(separator);
        }
        return builder.toString();
    }

    public String adaugaLinieNouaDupaPunct(List<String> lines) {
        String separator = System.lineSeparator();
        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            String[] propozitii = line.split("(?<=\\.)");
            for (String propozitie : propozitii) {
                builder.append(propozitie.trim());
                if (!propozitie.endsWith(".")) {
                    builder.append(' ');
                }
                builder.append(separator);
            }
        }
        return builder.toString();
    }

    public List<String> construiesteContinutOut(String rezultatA, String rezultatB) {
        List<String> output = new ArrayList<>();
        output.add("Rezultatul pentru punctul a):");
        output.add(rezultatA);
        output.add("Rezultatul pentru punctul b):");
        output.add(rezultatB);
        return output;
    }

    public void scrieRezultat(Path path, List<String> lines) throws IOException {
        Files.write(path, lines);
    }
}
