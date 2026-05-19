package student;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class StudentiInFisierXlsx implements IStudentiExport {
    private final String fileName;

    public StudentiInFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        Path path = Paths.get(fileName);

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Studenti");
            scrieHeader(sheet.createRow(0));

            for (int i = 0; i < studenti.size(); i++) {
                scrieStudent(sheet.createRow(i + 1), studenti.get(i));
            }

            Path parent = path.getParent();
            if (parent != null) {
                Files.createDirectories(parent);
            }

            try (OutputStream outputStream = Files.newOutputStream(path)) {
                workbook.write(outputStream);
            }
        } catch (IOException e) {
            System.out.println("Nu s-a putut scrie fisierul Excel: " + e.getMessage());
        }
    }

    private void scrieHeader(Row row) {
        row.createCell(0).setCellValue("numarMatricol");
        row.createCell(1).setCellValue("prenume");
        row.createCell(2).setCellValue("nume");
        row.createCell(3).setCellValue("formatieDeStudiu");
        row.createCell(4).setCellValue("nota");
    }

    private void scrieStudent(Row row, Student student) {
        row.createCell(0).setCellValue(student.getNumarMatricol());
        row.createCell(1).setCellValue(student.getPrenume());
        row.createCell(2).setCellValue(student.getNume());
        row.createCell(3).setCellValue(student.getFormatieDeStudiu());
        row.createCell(4).setCellValue(student.getNota());
    }
}
