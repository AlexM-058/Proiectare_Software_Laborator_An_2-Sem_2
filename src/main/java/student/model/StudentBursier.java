package student.model;

/*
 * Lab history:
 * - Lab 5: specializare prin mostenire pentru studentii bursieri.
 */

import java.util.Locale;
import java.util.Objects;

public class StudentBursier extends Student {
    private final double cuantumBursa;

    public StudentBursier(
            int numarMatricol,
            String prenume,
            String nume,
            String formatieDeStudiu,
            double nota,
            double cuantumBursa
    ) {
        super(numarMatricol, prenume, nume, formatieDeStudiu, nota);
        this.cuantumBursa = cuantumBursa;
    }

    public double getCuantumBursa() {
        return cuantumBursa;
    }

    @Override
    public StudentBursier withNota(double nota) {
        return new StudentBursier(
                getNumarMatricol(),
                getPrenume(),
                getNume(),
                getFormatieDeStudiu(),
                nota,
                cuantumBursa
        );
    }

    @Override
    public StudentBursier withFormatieDeStudiu(String nouaFormatieDeStudiu) {
        return new StudentBursier(
                getNumarMatricol(),
                getPrenume(),
                getNume(),
                nouaFormatieDeStudiu,
                getNota(),
                cuantumBursa
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cuantumBursa);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentBursier that = (StudentBursier) o;
        return Double.compare(that.cuantumBursa, cuantumBursa) == 0 && super.equals(o);
    }

    @Override
    public String toCsvLine() {
        return getNumarMatricol() + "," +
                getPrenume() + "," +
                getNume() + "," +
                getFormatieDeStudiu() + "," +
                String.format(Locale.US, "%.2f", getNota()) + "," +
                String.format(Locale.US, "%.2f", cuantumBursa);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(Locale.US, " [ %6.2f ]", cuantumBursa);
    }
}
