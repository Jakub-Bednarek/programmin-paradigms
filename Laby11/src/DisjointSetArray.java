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
    public int find(int x){
        if(parent[x] != x){
            return find(parent[x]);
        }

        return parent[x];
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
        System.out.println("\nSet printed:");
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

    private void makeSet(int size){
        for(int i = 0; i < size; i++){
            parent[i] = i;
        }
    }
}
