package student.decorator;

/*
 * Lab history:
 * - Lab 11: Decorator pentru masurarea timpului de executie al exporturilor.
 */

import student.model.Student;
import student.strategy.IStudentiExport;

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
