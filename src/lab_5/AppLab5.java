package lab_5;

public class AppLab5 {

    static void main(String[] args) {
        IntCalculator calculator = new IntCalculator(3);
        calculator.add(10).substract(3).multiply(3);
        int c = calculator.result() ;
        System.out.println(c);
    }
}
