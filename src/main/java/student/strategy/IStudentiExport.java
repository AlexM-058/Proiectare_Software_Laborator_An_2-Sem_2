package student.strategy;

/*
 * Lab history:
 * - Lab 10: contract comun pentru strategiile de export studenti.
 */

import student.model.Student;

import java.util.List;

public interface IStudentiExport {
    void doExport(List<Student> studenti);
}
