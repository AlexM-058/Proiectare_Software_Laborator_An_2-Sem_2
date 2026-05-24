package student.strategy.imports;

/*
 * Lab history:
 * - Lab 10: strategie concreta pentru importul studentilor din fisier Excel.
 */

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import student.model.Student;
import student.strategy.IStudentiImport;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierXlsx implements IStudentiImport {
    private final String fileName;

    public StudentiDinFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Student> doImport() {
        List<Student> studenti = new ArrayList<>();
        Path path = Paths.get(fileName);

        try (Workbook workbook = WorkbookFactory.create(path.toFile())) {
            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }

                Student student = new Student(
                        (int) row.getCell(0).getNumericCellValue(),
                        getText(row.getCell(1)),
                        getText(row.getCell(2)),
                        getText(row.getCell(3)),
                        row.getCell(4).getNumericCellValue()
                );
                studenti.add(student);
            }
        } catch (IOException e) {
            System.out.println("Nu s-a putut citi fisierul Excel: " + e.getMessage());
        }

        return studenti;
    }

    private String getText(Cell cell) {
        if (cell == null) {
            return "";
        }
        if (cell.getCellType() == CellType.NUMERIC) {
            return Double.toString(cell.getNumericCellValue());
        }
        return cell.getStringCellValue();
    }
}
