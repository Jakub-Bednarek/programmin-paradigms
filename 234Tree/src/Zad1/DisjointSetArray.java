package Zad1;

public class DisjointSetArray {
    private int[] rank;
    private int[] parent;
    private int size;

    public DisjointSetArray(int size){
        this.rank = new int[size];
        this.parent = new int[size];
        this.size = size;

        makeSet(size);
    }

    public void union(int x, int y){
        int xBase = find(x);
        int yBase = find(y);

        if(xBase == yBase)
            return;

        if(rank[xBase] == rank[yBase])
            parent[xBase] = yBase;
        else if(rank[yBase] < rank[xBase])
            parent[yBase] = xBase;
        else{
            parent[yBase] = xBase;
            rank[xBase]++;
        }
    }

    //bez kompresji i równoważenia
    public int find(int value){
        if(parent[value] != value){
            return find(parent[value]);
        }

        return parent[value];
    }

    //z kompresją ścieżek
    public int findCompress(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public void printRanks(){
        for(int r : rank)
            System.out.print(r + " ");
    }

    public void printStructure(){
        System.out.println("\nWydrukowany zbiór:");
        for(int i = 0; i < size; i++){
            if(parent[i] == i){
                System.out.print(i + ": ");

                for(int j = 0; j < size; j++){
                    if(find(j) == i){
                        System.out.print(j + " ");
                    }
                }
                System.out.println();
            }
        }
    }

    public boolean isFriendOf(int x, int y){
        if(find(x) == find(y)) {
            System.out.println(x + " ma takiego samego reprezentanta jak " + y);
            return true;
        } else {
            System.out.println(x + " nie ma takiego samego reprezentanta jak " + y);
            return false;
        }
    }

    private void makeSet(int size){
        for(int i = 0; i < size; i++){
            parent[i] = i;
        }
    }
}
