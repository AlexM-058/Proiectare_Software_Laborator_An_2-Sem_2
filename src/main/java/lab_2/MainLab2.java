package lab_2;

public class MainLab2 {
    public static void main(String[] args) {
        ManipulareColectie colectie = new ManipulareColectie(4);
        ManipulareColectie.populate(colectie.getX(), 5);
        ManipulareColectie.populate(colectie.getY(), 7);

        System.out.println("Lista X:");
        colectie.afiseazaLista(colectie.getX());

        System.out.println("Lista Y:");
        colectie.afiseazaLista(colectie.getY());

        colectie.calculeazaReuniunea();
        System.out.println("X + Y:");
        colectie.afiseazaLista(colectie.getXPlusY());

        colectie.calculeazaIntersectia();
        System.out.println("Z = X intersectat cu Y:");
        colectie.afiseazaSet(colectie.getZSet());

        colectie.calculeazaDiferenta();
        System.out.println("X - Y:");
        colectie.afiseazaLista(colectie.getXMinusY());

        colectie.calculeazaElementeleLimitateDeP();
        System.out.println("X + Y limitat de p:");
        colectie.afiseazaLista(colectie.getXPlusYLimitedByP());
    }
}
