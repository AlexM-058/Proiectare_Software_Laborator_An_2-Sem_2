package student.app;

/*
 * Lab history:
 * - Lab 10: demo pentru Strategy Pattern in exportul studentilor.
 * - Lab 11: integrare Decorator pentru masurarea timpului de export.
 */

import student.decorator.ExportTimerDecorator;
import student.model.Student;
import student.strategy.Exporter;
import student.strategy.IStudentiExport;
import student.strategy.IStudentiImport;
import student.strategy.export.StudentiInConsola;
import student.strategy.export.StudentiInFisierText;
import student.strategy.export.StudentiInFisierXlsx;
import student.strategy.imports.StudentiDinFisierText;
import student.strategy.imports.StudentiDinFisierXlsx;

import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy {
    public static void main(String[] args) {
        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90),
                new Student(1029, "Bianca", "Popescu", "TI131/1,", 10),
                new Student(1029, "Maria", "Pana", "TI131/2,", 4.10),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2,", 7.33),
                new Student(1029, "Marius", "Nasta", "TI131/2,", 3.20),
                new Student(1029, "Marius", "Nasta", "TI131/1,", 5.12),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2,", 2.22)
        );

        Exporter exporter = new Exporter();

        IStudentiExport strategyConsola = new StudentiInConsola();
        exporter.startExport(new ExportTimerDecorator(strategyConsola), studenti);

        System.out.println("----------------------------------------");

        String fisierText = "Outputs/studentiStrategyText.txt";
        IStudentiExport strategyFisierText = new StudentiInFisierText(fisierText);
        exporter.startExport(new ExportTimerDecorator(strategyFisierText), studenti);

        String fisierExcel = "Outputs/studentiStrategyExcel.xlsx";
        IStudentiExport strategyFisierExcel = new StudentiInFisierXlsx(fisierExcel);
        exporter.startExport(new ExportTimerDecorator(strategyFisierExcel), studenti);

        IStudentiImport citireText = new StudentiDinFisierText(fisierText);
        List<Student> studentiDinText = citireText.doImport();

        System.out.println("Studenti cititi din fisier text:");
        for (Student student : studentiDinText) {
            System.out.println(student);
        }

        System.out.println("----------------------------------------");

        IStudentiImport citireExcel = new StudentiDinFisierXlsx(fisierExcel);
        List<Student> studentiDinExcel = citireExcel.doImport();

        System.out.println("Studenti cititi din fisier Excel:");
        for (Student student : studentiDinExcel) {
            System.out.println(student);
        }
    }
}
