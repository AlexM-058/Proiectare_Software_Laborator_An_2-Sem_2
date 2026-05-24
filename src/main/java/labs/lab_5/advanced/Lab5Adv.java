package labs.lab_5.advanced;

public class Lab5Adv {

    static void main(String[] args) {
    NewIntCalculator first_calculator = new NewIntCalculator(0);
    DoubleCalculator second_calculator = new DoubleCalculator(0.0);

        //(10 + 5 - 3 ) *2 / 3
        Object first_result = first_calculator.add(10).add(5).subtract(3).multiply(2).divide(3).result();

        //(10 + 5 - 3.3 ) *2.2 / 3
        Object second_result = second_calculator.add(10.0).add(5.0).subtract(3.3).multiply(2.2).divide(3.0).result();

        System.out.println("Rezultatul pentru (10 + 5 - 3 ) * 2 / 3 este = " + first_result);
        System.out.println("Rezultatul pentru (10 + 5 - 3.3 ) * 2.2 / 3 este = " + second_result);

    }


}
