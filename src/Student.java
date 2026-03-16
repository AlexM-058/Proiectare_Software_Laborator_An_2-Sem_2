import java.util.*;
import java.util.List;

public class Student {
    protected int numarMatricol;
    protected  String prenume;
    protected  String nume;
    protected   String formatieDeStudiu;
    protected static Set<Student> Catalog = new HashSet<>();

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    public static void afisareCatalog() {
        for (Student s : Catalog) {
            System.out.println(s);
        }

    }
    public static boolean Check_student(Student student) {
        return Catalog.contains(student);
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return (numarMatricol == student.numarMatricol && prenume.equals(student.prenume)
                && nume.equals(student.nume) && formatieDeStudiu.equals(student.formatieDeStudiu));
    }
    @Override
    public int hashCode() {
        return Objects.hash(numarMatricol, prenume, nume, formatieDeStudiu);
    }


    public static void main(String[] args) {
//        Student student =new Student(120, "Alis", "Popa", "TI21/2");
//        Student student0 = new Student(112, "Maria", "Popa", "TI21/1",1);
        Catalog.add(new Student(112, "Maria", "Popa", "TI21/1"));
        Catalog.add(new Student(113, "Andrei", "Ionescu", "TI21/1"));
        Catalog.add(new Student(114, "Elena", "Georgescu", "TI21/1"));
        Catalog.add(new Student(115, "Vlad", "Dumitrescu", "TI21/2"));
        Catalog.add(new Student(116, "Ioana", "Stan", "TI21/2"));
        Catalog.add(new Student(117, "Radu", "Marin", "TI21/2"));
        Catalog.add(new Student(118, "Ana", "Petrescu", "TI21/3"));
        Catalog.add(new Student(119, "Mihai", "Enache", "TI21/3"));
        Catalog.add(new Student(120, "Bianca", "Ilie", "TI21/3"));
        Catalog.add( new Student(121, "Stefan", "Matei", "TI21/1"));


        Student cautat = new Student(112, "Maria", "Popa", "TI21/1");
        Student cautat2 = new Student(120, "Alis", "Popa", "TI21/2");

        System.out.println("\nCatalogul:");
        afisareCatalog();

       System.out.println("Cautarea a fost efectuata cu : "+  Check_student(cautat));
       System.out.println("Cautarea a fost efectuata cu :  " + Check_student(cautat2));
    }
}
