package lab_8;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.PrintStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lab8ExcelProcessor {
    private static final int FIRST_AVERAGE_COLUMN_INDEX = 3;
    private static final int LAST_AVERAGE_COLUMN_INDEX = 5;
    private static final int OUTPUT_AVERAGE_COLUMN_INDEX = 6;

    public void citesteSiAfiseazaExcel(Path inputPath) throws IOException {
        citesteSiAfiseazaExcel(inputPath, System.out);
    }

    public void citesteSiAfiseazaExcel(Path inputPath, PrintStream output) throws IOException {
        try (Workbook workbook = WorkbookFactory.create(inputPath.toFile())) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                StringBuilder line = new StringBuilder();
                for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
                    Cell cell = row.getCell(cellIndex);
                    if (cellIndex > 0) {
                        line.append(" | ");
                    }
                    line.append(formatCellValue(cell));
                }
                output.println(line);
            }
        }
    }

    public void copiazaCuMedieCalculata(Path inputPath, Path outputPath) throws IOException {
        try (
                Workbook inputWorkbook = WorkbookFactory.create(inputPath.toFile());
                Workbook outputWorkbook = new XSSFWorkbook()
        ) {
            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            Sheet outputSheet = outputWorkbook.createSheet(inputSheet.getSheetName());
            copySheetWithAverage(inputSheet, outputSheet, false);
            writeWorkbook(outputWorkbook, outputPath);
        }
    }

    public void copiazaCuFormulaMedie(Path inputPath, Path outputPath) throws IOException {
        try (
                Workbook inputWorkbook = WorkbookFactory.create(inputPath.toFile());
                Workbook outputWorkbook = new XSSFWorkbook()
        ) {
            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            Sheet outputSheet = outputWorkbook.createSheet(inputSheet.getSheetName());
            copySheetWithAverage(inputSheet, outputSheet, true);
            writeWorkbook(outputWorkbook, outputPath);
        }
    }

    private void copySheetWithAverage(Sheet inputSheet, Sheet outputSheet, boolean useFormula) {
        for (Row inputRow : inputSheet) {
            Row outputRow = outputSheet.createRow(inputRow.getRowNum());
            copyRow(inputRow, outputRow);

            Cell averageCell = outputRow.createCell(OUTPUT_AVERAGE_COLUMN_INDEX);
            if (inputRow.getRowNum() == 0) {
                averageCell.setCellValue("Media");
            } else if (useFormula) {
                int excelRowNumber = inputRow.getRowNum() + 1;
                averageCell.setCellFormula("AVERAGE(D" + excelRowNumber + ":F" + excelRowNumber + ")");
            } else {
                averageCell.setCellValue(calculateAverage(inputRow));
            }
        }
    }

    private void copyRow(Row inputRow, Row outputRow) {
        for (int cellIndex = 0; cellIndex < inputRow.getLastCellNum(); cellIndex++) {
            Cell inputCell = inputRow.getCell(cellIndex);
            if (inputCell != null) {
                copyCell(inputCell, outputRow.createCell(cellIndex));
            }
        }
    }

    private void copyCell(Cell inputCell, Cell outputCell) {
        CellType cellType = inputCell.getCellType();
        if (cellType == CellType.STRING) {
            outputCell.setCellValue(inputCell.getStringCellValue());
        } else if (cellType == CellType.NUMERIC) {
            outputCell.setCellValue(inputCell.getNumericCellValue());
        } else if (cellType == CellType.BOOLEAN) {
            outputCell.setCellValue(inputCell.getBooleanCellValue());
        } else if (cellType == CellType.FORMULA) {
            outputCell.setCellFormula(inputCell.getCellFormula());
        } else if (cellType == CellType.BLANK) {
            outputCell.setBlank();
        }
    }

    private double calculateAverage(Row row) {
        double sum = 0.0;
        int count = 0;

        for (int cellIndex = FIRST_AVERAGE_COLUMN_INDEX; cellIndex <= LAST_AVERAGE_COLUMN_INDEX; cellIndex++) {
            Cell cell = row.getCell(cellIndex);
            if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                sum += cell.getNumericCellValue();
                count++;
            }
        }

        if (count == 0) {
            return 0.0;
        }
        return sum / count;
    }

    private String formatCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }

        CellType cellType = cell.getCellType();
        if (cellType == CellType.STRING) {
            return cell.getStringCellValue();
        }
        if (cellType == CellType.NUMERIC) {
            return Double.toString(cell.getNumericCellValue());
        }
        if (cellType == CellType.BOOLEAN) {
            return Boolean.toString(cell.getBooleanCellValue());
        }
        if (cellType == CellType.FORMULA) {
            return cell.getCellFormula();
        }
        return "";
    }

    private void writeWorkbook(Workbook workbook, Path outputPath) throws IOException {
        Path parent = outputPath.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
        try (OutputStream outputStream = Files.newOutputStream(outputPath)) {
            workbook.write(outputStream);
        }
    }
}
