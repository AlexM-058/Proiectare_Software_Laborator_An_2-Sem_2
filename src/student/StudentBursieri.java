package student;

import java.util.Locale;
import java.util.Objects;

public class StudentBursieri extends Student {
    private final double cuantumBursa;

    public StudentBursieri(
            int numarMatricol,
            String prenume,
            String nume,
            String formatieDeStudiu,
            double nota,
            double cuantumBursa
    ) {
        super(numarMatricol, prenume, nume, formatieDeStudiu);
        setNota(nota);
        this.cuantumBursa = cuantumBursa;
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
        StudentBursieri that = (StudentBursieri) o;
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
        return super.toString() + " cuantumBursa: " + cuantumBursa;
    }
}
