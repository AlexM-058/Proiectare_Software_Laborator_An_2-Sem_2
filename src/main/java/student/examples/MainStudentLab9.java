package student.examples;

import student.Student;
import java.util.*;


public class MainStudentLab9 {
    private final List<Student> students = new ArrayList<>();

    MainStudentLab9() {
        students.addAll(Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90),
                new Student(1029, "Bianca", "Popescu", "TI131/1", 10),
                new Student(1029, "Maria", "Pana", "TI131/2", 4.10),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2", 7.33),
                new Student(1029, "Marius", "Nasta", "TI131/2", 3.20),
                new Student(1029, "Marius", "Nasta", "TI131/1", 5.12),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22)
        ));

    }
    protected void showTopStudents(){
        students.stream()
                .filter(student -> student.getNota() == 10)
                .forEach(student -> System.out.println(student + " "));
        System.out.println();
    }
    protected void showStudentsUnderFive(){
        students.stream()
                .filter(student -> student.getNota() < 5)
                .forEach(student -> System.out.println(student + " "));
        System.out.println();
    }
    protected void modifyList(){
        students.stream()
                .filter(student -> student.getNota() < 4)
                .forEach(student -> {
                    student.setNota(4.00);
                    System.out.println(student + " ");
                });


    }
    protected double sumOfGrades(){
        return students.stream()
                .map(Student::getNota)
                .reduce(0.0, Double::sum);
    }
    protected double averageGrade(){
        double sum = sumOfGrades();
        return sum/students.size();

    }
    public static void main(String[] args) {
       MainStudentLab9 theList = new MainStudentLab9();
       theList.showTopStudents();
        theList.showStudentsUnderFive();
        theList.modifyList();
       double test = theList.sumOfGrades();
       System.out.println(test);
       double test2 = theList.averageGrade();
       System.out.println(test2);
    }
}
