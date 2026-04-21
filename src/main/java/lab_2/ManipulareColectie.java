package lab_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class ManipulareColectie {
    private final List<Integer> x = new ArrayList<>();
    private final List<Integer> y = new ArrayList<>();
    private final Collection<Integer> colectie = new ArrayList<>();
    private final List<Integer> xPlusY = new ArrayList<>();
    private final Set<Integer> zSet = new TreeSet<>();
    private final List<Integer> xMinusY = new ArrayList<>();
    private final List<Integer> xPlusYLimitedByP = new ArrayList<>();
    private final int p;

    public ManipulareColectie(int p) {
        this.p = p;
    }

    public List<Integer> getX() {
        return x;
    }

    public List<Integer> getY() {
        return y;
    }

    public List<Integer> getXPlusY() {
        return xPlusY;
    }

    public Set<Integer> getZSet() {
        return zSet;
    }

    public List<Integer> getXMinusY() {
        return xMinusY;
    }

    public List<Integer> getXPlusYLimitedByP() {
        return xPlusYLimitedByP;
    }

    public static void populate(List<Integer> list, int numberOfElements) {
        Random rand = new Random();
        for (int i = 0; i < numberOfElements; i++) {
            list.add(rand.nextInt(10));
        }
        list.sort(null);
    }

    public void calculeazaReuniunea() {
        colectie.clear();
        xPlusY.clear();
        colectie.addAll(x);
        colectie.addAll(y);
        xPlusY.addAll(colectie);
        xPlusY.sort(null);
    }

    public void calculeazaIntersectia() {
        zSet.clear();
        zSet.addAll(x);
        zSet.retainAll(y);
    }

    public void calculeazaDiferenta() {
        xMinusY.clear();
        xMinusY.addAll(x);
        xMinusY.removeAll(y);
    }

    public void calculeazaElementeleLimitateDeP() {
        xPlusYLimitedByP.clear();
        xPlusYLimitedByP.addAll(xPlusY);
        xPlusYLimitedByP.removeIf(element -> element > p);
    }

    public void afiseazaLista(List<Integer> list) {
        System.out.println(list);
    }

    public void afiseazaSet(Set<Integer> set) {
        System.out.println(set);
    }
}
