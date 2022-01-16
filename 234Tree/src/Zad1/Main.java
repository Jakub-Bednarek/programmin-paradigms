package Zad1;

public class Main {
    public static void main(String[] args){
        //Zbiory rozłączne na tablicach
        DisjointSetArray set = new DisjointSetArray(10);

        set.union(0, 2);
        set.union(1, 2);
        set.union(5, 2);

        set.printStructure();

        set.union(6, 4);
        set.union(6, 9);

        set.printStructure();

        set.isFriendOf(5, 1);
        set.isFriendOf(8, 2);
        set.isFriendOf(5, 8);

        set.union(3, 8);
        set.printStructure();

        //Zbiory rozłączne na bazie lasu drzew rozłącznych
        DisjointSetForest setForest = new DisjointSetForest(10);
        System.out.println("\nPrzed operacjami na zbiorze rozłącznym na bazie lasu drzew:");
        setForest.printAllParents();

        setForest.union(2, 4);
        setForest.union(5, 3);
        setForest.union(1, 6);
        setForest.printAllParents();

        setForest.union(9, 8);
        setForest.union(4, 8);
        setForest.union(3, 7);
        setForest.printAllParents();

        setForest.union(3, 8);
        setForest.printAllParents();
    }
}
