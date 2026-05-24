package student.strategy;

/*
 * Lab history:
 * - Lab 10: contract comun pentru strategiile de import studenti.
 */

import student.model.Student;

import java.util.List;

public interface IStudentiImport {
    List<Student> doImport();
}
