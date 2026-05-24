package student.strategy.export;

/*
 * Lab history:
 * - Lab 10: strategie concreta pentru exportul studentilor in consola.
 */

import student.model.Student;
import student.strategy.IStudentiExport;

import java.util.List;

public class StudentiInConsola implements IStudentiExport {
    @Override
    public void doExport(List<Student> studenti) {
        for (Student student : studenti) {
            System.out.println(student);
        }
    }
}
