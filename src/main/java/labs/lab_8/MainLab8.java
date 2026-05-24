package labs.lab_8;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainLab8 {
    private static final Path INPUT_PATH = Paths.get("Inputs", "laborator8_input.xlsx");
    private static final Path OUTPUT2_PATH = Paths.get("Outputs", "laborator8_output2.xlsx");
    private static final Path OUTPUT3_PATH = Paths.get("Outputs", "laborator8_output3.xlsx");

    public static void main(String[] args) {
        Lab8ExcelProcessor processor = new Lab8ExcelProcessor();
        try {
            processor.citesteSiAfiseazaExcel(INPUT_PATH);
            processor.copiazaCuMedieCalculata(INPUT_PATH, OUTPUT2_PATH);
            processor.copiazaCuFormulaMedie(INPUT_PATH, OUTPUT3_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
