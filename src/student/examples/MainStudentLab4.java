package student.examples;

import student.CatalogStudenti;
import student.Student;

public class MainStudentLab4 {
    public static void main(String[] args) {
        CatalogStudenti catalog = new CatalogStudenti();
        catalog.adaugaStudent(new Student(112, "Maria", "Popa", "TI21/1"));
        catalog.adaugaStudent(new Student(113, "Andrei", "Ionescu", "TI21/1"));
        catalog.adaugaStudent(new Student(114, "Elena", "Georgescu", "TI21/1"));
        catalog.adaugaStudent(new Student(115, "Vlad", "Dumitrescu", "TI21/2"));
        catalog.adaugaStudent(new Student(116, "Ioana", "Stan", "TI21/2"));
        catalog.adaugaStudent(new Student(117, "Radu", "Marin", "TI21/2"));
        catalog.adaugaStudent(new Student(118, "Ana", "Petrescu", "TI21/3"));
        catalog.adaugaStudent(new Student(119, "Mihai", "Enache", "TI21/3"));
        catalog.adaugaStudent(new Student(120, "Bianca", "Ilie", "TI21/3"));
        catalog.adaugaStudent(new Student(121, "Stefan", "Matei", "TI21/1"));

        Student cautat = new Student(112, "Maria", "Popa", "TI21/1");
        Student cautat2 = new Student(120, "Alis", "Popa", "TI21/2");

        System.out.println("Catalogul:");
        catalog.afiseazaCatalog();
        System.out.println("Studentul cautat exista: " + catalog.getStudenti().contains(cautat));
        System.out.println("Studentul cautat 2 exista: " + catalog.getStudenti().contains(cautat2));
    }
}
