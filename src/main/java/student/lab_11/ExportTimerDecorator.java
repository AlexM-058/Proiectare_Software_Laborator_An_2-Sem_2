package student.lab_11;

import student.IStudentiExport;
import student.Student;

import java.util.List;

public class ExportTimerDecorator implements IStudentiExport {
    private final IStudentiExport exporter;

    public ExportTimerDecorator(IStudentiExport exporter) {
        this.exporter = exporter;
    }

    @Override
    public void doExport(List<Student> studenti) {
        long startTime = System.currentTimeMillis();
        exporter.doExport(studenti);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Export execution time: " + duration + " ms");
    }
}
