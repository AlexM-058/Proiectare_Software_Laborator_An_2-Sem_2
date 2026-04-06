package student;

import java.util.Objects;

public class StudentBursieri extends Student{

    double cuantumBursa ;

    public StudentBursieri(int numarMatricol, String prenume,
                           String nume, String formatieDeStudiu, double cuantumBursa) {
        super(numarMatricol, prenume, nume, formatieDeStudiu);
        this.cuantumBursa = cuantumBursa;
    }
    @Override
    public int hashCode() {
        return Objects.hash(numarMatricol, prenume, nume, formatieDeStudiu, cuantumBursa);
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
    public String toString() {
        return super.toString() + " cuantumBursa: " + cuantumBursa;
    }

}
