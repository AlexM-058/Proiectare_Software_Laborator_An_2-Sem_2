package lab_9;

import java.util.ArrayList;
import java.util.*;

public class MainLab9 {
    //9.3.1
    private List<Integer> randomNumbers = new ArrayList<>();
    private List<Integer> numbers = new ArrayList<>();
    private List<Double> doublenumbers = new ArrayList<>();

    protected void generateRandomNumbers() {
        randomNumbers.clear();
        for (int i = 0; i < 10; i++) {
            int num = (int) (Math.random() * (25 - 5 + 1)) + 5;
            randomNumbers.add(num);
        }
    }

    protected int sumRandomNumbers() {
        int sum = randomNumbers.stream()
                .peek(x -> System.out.print(x + " "))
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("\nSuma totala: " + sum);
        return sum;
    }
    protected int maxRandomNumbers() {
        int max = randomNumbers.stream().max(Integer::compare).get();
        System.out.println("The max number is " + max);

        return max;
    }
    protected int minRandomNumbers() {
        int min = randomNumbers.stream().min(Integer::compare).get();
        System.out.println("The min number is " + min);
        return min;
    }
    protected void newlistwithRandomNumbersbetween10and20() {
        numbers.clear();
        randomNumbers.stream().filter(x -> x >= 10 && x <= 20)
                .forEach(x -> numbers.add(x));
        numbers.sort(Collections.reverseOrder());
        numbers.forEach(x -> System.out.print(x + " "));
        System.out.println();

    }
    protected void newListTransformedinDoubble(){
        randomNumbers.stream().mapToDouble(x->x)
                .forEach(x -> doublenumbers.add(x));
    }
    protected void find12(){
       boolean found = randomNumbers.stream().anyMatch(x -> x == 12);
       String text = found ? "12 found":"12 not found";
       System.out.println(text);
    }
    //9.3.2
    private List<String> listaCuvintelor = new ArrayList<>();
    private String propozitie = "Acesta este un program scris in java pentru expresii lambada";

    protected void findWordsLongerThan5(){
        listaCuvintelor.clear();
        Arrays.stream(propozitie.split("\\s+"))
                .filter(word -> word.length() > 5)
                .forEach(x ->{
                        listaCuvintelor.add(x);
                        System.out.print( x + " ");}) ;
        System.out.println();
    }
    protected void findLetterP(){
        listaCuvintelor.stream()
                .filter(word ->word.startsWith("p"))
                .forEach(x ->System.out.print(x + " "));
        System.out.println();
    }

    protected void sortList(){

        listaCuvintelor.stream().sorted().forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        MainLab9 app = new MainLab9();
        app.generateRandomNumbers();
        int sum = app.sumRandomNumbers();
        int max = app.maxRandomNumbers();
        int min = app.minRandomNumbers();
        app.newlistwithRandomNumbersbetween10and20();
        app.find12();
        app.findWordsLongerThan5();
        app.sortList();
        app.findLetterP();
    }
}