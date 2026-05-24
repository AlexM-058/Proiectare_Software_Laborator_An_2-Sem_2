package student.strategy;

/*
 * Lab history:
 * - Lab 10: context Strategy care executa orice implementare IStudentiExport.
 */

import student.model.Student;

import java.util.List;

public class Exporter {
    public void startExport(IStudentiExport studentiExport, List<Student> studenti) {
        studentiExport.doExport(studenti);
    }
}
