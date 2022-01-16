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

        if(set.find(5) == set.find(1))
            System.out.println("5 is friend of 1");
        else
            System.out.println("5 isn't friend of 1");
        if(set.find(8) == set.find(2))
            System.out.println("8is friend of 2");
        else
            System.out.println("8 isn't friend of 2");

        set.union(3, 8);
        set.printStructure();

        //Zbiory rozłączne na bazie lasu drzew rozłącznych
        DisjointSetForest setForest = new DisjointSetForest(10);
        setForest.printAllParents();
    }
}
