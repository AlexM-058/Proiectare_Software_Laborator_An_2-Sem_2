package student;

import java.util.List;

public class StudentiInConsola implements IStudentiExport {
    @Override
    public void doExport(List<Student> studenti) {
        for (Student student : studenti) {
            System.out.println(student);
        }
    }
}
