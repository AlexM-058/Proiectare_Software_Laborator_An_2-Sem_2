package student.examples;

import labs.lab_3.StudentFileProcessor;
import student.model.Student;
import student.model.StudentBursier;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MainStudentLab5 {
    private static final Path BURSIERI_OUTPUT_PATH = Paths.get("Outputs", "bursieri_out.txt");

    public static void main(String[] args) {
        StudentFileProcessor studentFileProcessor = new StudentFileProcessor();
        List<Student> bursieri = new ArrayList<>();

        bursieri.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70, 725.50));
        bursieri.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80, 801.10));
        bursieri.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90, 745.50));
        bursieri.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1", 9.10, 780.80));

        try {
            studentFileProcessor.scrieStudenti(BURSIERI_OUTPUT_PATH, bursieri);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
