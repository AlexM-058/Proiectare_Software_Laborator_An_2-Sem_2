import java.util.*;
import java.util.List;

public class Student {
    protected int numarMatricol;
    protected  String prenume;
    protected  String nume;
    protected   String formatieDeStudiu;
    protected static List<Student> Catalog = new ArrayList<>();

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu, int add) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        if (add == 1) {
            Catalog.add(this);
        } 
        
    }
    public static void afisareCatalog() {
        for (Student s : Catalog) {
            System.out.println(s);
        }

    }
    public static boolean Check_student(Student student) {
        for (Student s : Catalog) {
            if (s.numarMatricol == student.numarMatricol
                    && s.formatieDeStudiu == student.formatieDeStudiu
            && s.prenume == student.prenume && s.nume == student.nume) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Student = " +
                " numarMatricol='" + numarMatricol + '\'' +
                " prenume='" + prenume + '\'' +
                " nume='" + nume + '\'' +
                " formatieDeStudiu='" + formatieDeStudiu + '\''
                ;
    }
    public static void main(String[] args) {
//        Student student =new Student(120, "Alis", "Popa", "TI21/2");
        Student student0 = new Student(112, "Maria", "Popa", "TI21/1",1);
        Student student1 = new Student(112, "Maria", "Popa", "TI21/1",1);
        Student student2 = new Student(113, "Andrei", "Ionescu", "TI21/1",1);
        Student student3 = new Student(114, "Elena", "Georgescu", "TI21/1",1);
        Student student4 = new Student(115, "Vlad", "Dumitrescu", "TI21/2",1);
        Student student5 = new Student(116, "Ioana", "Stan", "TI21/2",1);
        Student student6 = new Student(117, "Radu", "Marin", "TI21/2",1);
        Student student7 = new Student(118, "Ana", "Petrescu", "TI21/3",1);
        Student student8 = new Student(119, "Mihai", "Enache", "TI21/3",1);
        Student student9 = new Student(120, "Bianca", "Ilie", "TI21/3",1);
        Student student10 = new Student(121, "Stefan", "Matei", "TI21/1",1);


        Student cautat = new Student(112, "Maria", "Popa", "TI21/1",0);
        Student cautat2 = new Student(120, "Alis", "Popa", "TI21/2",0);

        System.out.println("\nCatalogul:");
        afisareCatalog();

       System.out.println("Cautarea a fost efectuata cu : "+  Check_student(cautat));
       System.out.println("Cautarea a fost efectuata cu :  " + Check_student(cautat2));
    }
}
