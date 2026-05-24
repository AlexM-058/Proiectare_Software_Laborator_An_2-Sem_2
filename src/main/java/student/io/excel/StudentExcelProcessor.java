package student.io.excel;

/*
 * Lab history:
 * - Lab 8: integrare Apache POI pentru export si import Excel.
 */

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import student.model.StudentBursier;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StudentExcelProcessor {
    public void exportaStudenti(Path outputPath, List<StudentBursier> studenti) throws IOException {
        try (Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Studenti");
            writeHeader(sheet.createRow(0));

            for (int index = 0; index < studenti.size(); index++) {
                writeStudent(sheet.createRow(index + 1), studenti.get(index));
            }

            Path parent = outputPath.getParent();
            if (parent != null) {
                Files.createDirectories(parent);
            }

            try (OutputStream outputStream = Files.newOutputStream(outputPath)) {
                workbook.write(outputStream);
            }
        }
    }

    public List<StudentBursier> citesteStudenti(Path inputPath) throws IOException {
        List<StudentBursier> studenti = new ArrayList<>();

        try (Workbook workbook = WorkbookFactory.create(inputPath.toFile())) {
            Sheet sheet = workbook.getSheetAt(0);
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row != null) {
                    studenti.add(readStudent(row));
                }
            }
        }

        return studenti;
    }

    private void writeHeader(Row row) {
        row.createCell(0).setCellValue("numarMatricol");
        row.createCell(1).setCellValue("prenume");
        row.createCell(2).setCellValue("nume");
        row.createCell(3).setCellValue("formatieDeStudiu");
        row.createCell(4).setCellValue("nota");
        row.createCell(5).setCellValue("cuantumBursa");
    }

    private void writeStudent(Row row, StudentBursier student) {
        row.createCell(0).setCellValue(student.getNumarMatricol());
        row.createCell(1).setCellValue(student.getPrenume());
        row.createCell(2).setCellValue(student.getNume());
        row.createCell(3).setCellValue(student.getFormatieDeStudiu());
        row.createCell(4).setCellValue(student.getNota());
        row.createCell(5).setCellValue(student.getCuantumBursa());
    }

    private StudentBursier readStudent(Row row) {
        return new StudentBursier(
                (int) row.getCell(0).getNumericCellValue(),
                getStringCellValue(row.getCell(1)),
                getStringCellValue(row.getCell(2)),
                getStringCellValue(row.getCell(3)),
                row.getCell(4).getNumericCellValue(),
                row.getCell(5).getNumericCellValue()
        );
    }

    private String getStringCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        if (cell.getCellType() == CellType.NUMERIC) {
            return Double.toString(cell.getNumericCellValue());
        }
        return cell.getStringCellValue();
    }
}
