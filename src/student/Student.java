package student;

import java.util.Locale;
import java.util.Objects;

public class Student {
    private final int numarMatricol;
    private final String prenume;
    private final String nume;
    private final String formatieDeStudiu;
    private double nota;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    public int getNumarMatricol() {
        return numarMatricol;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }

    public double getNota() {
        return nota;
    }

    public String toCsvLine() {
        return numarMatricol + "," + prenume + "," + nume + "," + formatieDeStudiu;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Student{" +
                "numarMatricol=" + numarMatricol +
                ", prenume='" + prenume + '\'' +
                ", nume='" + nume + '\'' +
                ", formatieDeStudiu='" + formatieDeStudiu + '\'' +
                ", nota=" + String.format(Locale.US, "%.2f", nota) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return numarMatricol == student.numarMatricol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numarMatricol);
    }
}
