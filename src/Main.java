import java.util.*;


public class    Main {
    static void main(String[] args) {
        Student student = new Student("12345", "Ana", "Popescu", "Informatica");
        System.out.println(student);
        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();
        List<Integer> xPlusY = new ArrayList(); //a
        Set<Integer> zSet = new TreeSet(); //b
        List<Integer> xMinusY = new ArrayList();//c
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList(); //d
        Random rand = new Random();
        for(int i = 0 ; i < 10 ; i++) {
           x.add( rand.nextInt(10));
            System.out.print(x.get(i) + " ");
        }
        System.out.println();
        for(int i = 0 ; i < 10 ; i++) {
            y.add( rand.nextInt(10));
            System.out.print(y.get(i) + " ");
        }

    }
}
