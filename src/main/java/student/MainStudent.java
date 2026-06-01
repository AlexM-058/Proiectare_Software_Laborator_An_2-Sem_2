package student;

import student.examples.MainStudentLab5;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MainStudent {
    private static final Path STUDENTS_XLS_PATH = Paths.get("Outputs", "laborator8_students.xls");

    public static void main(String[] args) {
        MainStudentLab5.main(args);

        AplicatieCuBursa aplicatie = new AplicatieCuBursa();
        List<StudentBursier> studenti = aplicatie.genereaza();
        StudentExcelProcessor processor = new StudentExcelProcessor();

        try {
            processor.exportaStudenti(STUDENTS_XLS_PATH, studenti);
            List<StudentBursier> studentiCititi = processor.citesteStudenti(STUDENTS_XLS_PATH);
            for (StudentBursier student : studentiCititi) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
