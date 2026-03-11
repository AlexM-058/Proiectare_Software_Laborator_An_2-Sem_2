public class Student {
    protected String numarMatricol;
    protected  String prenume;
    protected  String nume;
    protected   String formatieDeStudiu;

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
