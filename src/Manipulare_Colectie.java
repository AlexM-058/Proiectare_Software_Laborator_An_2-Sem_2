import java.util.*;
//Tema lab 2 
public class Manipulare_Colectie {
     public List<Integer> x = new ArrayList<>();
    public List<Integer> y = new ArrayList<>();
    public Collection<Integer> colectie = new ArrayList<>();
    public List<Integer> xPlusY = new ArrayList(); //a
    public Set<Integer> zSet = new TreeSet(); //b
    public List<Integer> xMinusY = new ArrayList();//c
    public List<Integer> xPlusYLimitedByP = new ArrayList(); //d
    int p = 4;

    public Manipulare_Colectie() {
    }

    public void addAll(Collection<Integer> values) {
        this.colectie.addAll(values);
    }

    public void add(Integer value) {
        this.colectie.add(value);
    }

    public static void populate(List<Integer> list, int numberOfElements) {
        Random rand = new Random();
        for (int i = 0; i < numberOfElements; i++) {
            list.add(rand.nextInt(10));
        }
        list.sort(null);
    }

    public void afis(List<Integer> list) {

        System.out.println(list);
    }

    public List<Integer> getX() {
        return x;
    }

    public List<Integer> getY() {
        return y;
    }

    public Collection<Integer> getColectie() {
        return colectie;
    }
    public void Plus() {
        colectie.addAll(x);
        colectie.addAll(y);
        xPlusY.addAll(colectie);
        colectie.clear();
        xPlusY.sort(null);
    }
    public void ZSet() {
        zSet.addAll(x);
        zSet.retainAll(y);
    }

    public void XMinusY() {
        xMinusY.addAll(x);
        xMinusY.removeAll(y);
    }
    public void XPlusYLimitedByP() {
        xPlusYLimitedByP.addAll(xPlusY);
        xPlusYLimitedByP.removeIf(e -> e > p);
    }
    public void afis_XPlusY() {
        System.out.println(xPlusY);
    }
    public void afis_ZSet() {
        System.out.println(zSet);
    }
    public void afis_XMinusY() {
        System.out.println(xMinusY);
    }
    public void afis_XPlusYLimitedByP() {
        System.out.println(xPlusYLimitedByP);
    }
    public void afis_Colectie() {
        System.out.println(colectie);
    }
    public static void main(String[] args) {
        Manipulare_Colectie obj = new Manipulare_Colectie();
        obj.populate(obj.getX(), 5);
        obj.populate(obj.getY(), 7);
        obj.afis(obj.getX());
        obj.afis(obj.getY());
        obj.Plus();
        obj.afis_XPlusY();
        obj.ZSet();
        obj.afis_ZSet();
        obj.XMinusY();
        obj.afis_XMinusY();
        obj.XPlusYLimitedByP();
        obj.afis_XPlusYLimitedByP();



    }
}
