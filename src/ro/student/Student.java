package ro.student;

public class Student {
    private final String numarMatricol;
    private final String prenume;
    private final String nume;
    private final String formatieDeStudiu;

    public Student(String numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
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
}
