package labs.lab_7;

import labs.lab_7.forms.Circle;
import labs.lab_7.forms.Form;
import labs.lab_7.forms.Square;
import labs.lab_7.forms.Triangle;
import labs.lab_7.util.PasswordMaker;
import student.model.Student;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // 7.6.1. Contor instante
        Triangle tri = new Triangle(1.1F, 2.0F, "red");
        Circle c = new Circle(1.5F, "yellow");
        Square sq = new Square(1.2F, "blue");
        System.out.println("Area = " + tri.getArea()+" details: " + tri);
        System.out.println("Area = " + c.getArea() + " details: " + c);
        System.out.println("Area = " + sq.getArea() + " details: " + sq);
        System.out.println("Total instance count is " + Form.getInstanceCount());   // sau tri.getInstanceCount() sau sq.getInstanceCount()

        //7.6.2 Password maker singleton
        PasswordMaker pm2 = PasswordMaker.getInstance();
        System.out.println("\n7.6.2 a+b) Generated passwords: ");
        System.out.println("1:" + PasswordMaker.getInstance().getPassword());
        System.out.println("2:" + PasswordMaker.getInstance().getPassword());
        System.out.println("3:" + PasswordMaker.getInstance().getPassword());
        System.out.println("4:" + pm2.getPassword());
        System.out.println("5:" + pm2.getPassword());
        System.out.println("\n7.6.2 c) Number of time getInstance() has been called: "+PasswordMaker.getCallingCounts());

        //7.6.3 Imutabilitate
        Set<Student> studenti = new LinkedHashSet<>();
        studenti.add(new Student(1, "Ana", "Popescu", "TI 211"));
        studenti.add(new Student(2, "Bogdan", "Ionescu", "TI 211"));
        studenti.add(new Student(3, "Carmen", "Stan", "TI 211"));
        studenti.add(new Student(4, "Dan", "Marin", "TI 211"));
        studenti.add(new Student(5, "Elena", "Vasile", "TI 211"));

        studenti = imparteInDouaFormatii(studenti, "TI 211_1", "TI 211_2");
        System.out.println("\n7.6.3 Studentii impartiti in doua formatii:");
        for (Student student : studenti) {
            System.out.println(student);
        }
    }

    static Set<Student> imparteInDouaFormatii(Set<Student> studenti, String formatia1, String formatia2) {
        Set<Student> rezultat = new LinkedHashSet<>();
        int limitaFormatia1 = (studenti.size() + 1) / 2;
        int index = 0;

        for (Student student : studenti) {
            String nouaFormatie = index < limitaFormatia1 ? formatia1 : formatia2;
            rezultat.add(schimbaFormatia(student, nouaFormatie));
            index++;
        }

        return rezultat;
    }

    static Student schimbaFormatia(Student student, String nouaFormatieDeStudiu) {
        return student.withFormatieDeStudiu(nouaFormatieDeStudiu);
    }
}
