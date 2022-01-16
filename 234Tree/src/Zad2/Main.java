package Zad2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class Main {
    public static void main(String[] args){

        for(int i = 0; i < 5; i++){
            makeTest(100, "Test numer " + (i + 1));
            makeTest(1000, "Test numer " + (i + 1));
            makeTest(5000, "Test numer " + (i + 1));
            makeTest(10000, "Test numer " + (i + 1));
            makeTest(20000, "Test numer " + (i + 1));
        }
    }

    private static void makeTest(int size, String info){
        Set<Integer> numbers = SequenceGenerator.generateRandomList(size, 100000);
        Set<Integer> toFind = SequenceGenerator.generateRandomList(size / 2, 100000);
        resetCompares();

        BST<Integer> bstTree = new BST<>(new IntegerComparator());
        TwoFourTree<Integer> twoFourTree = new TwoFourTree<>(new IntegerComparator());
        RbTree rbTree = new RbTree();

        for(Integer i : numbers){
            bstTree.insert(i);
            twoFourTree.insert(i);
            rbTree.insert(rbTree, i);
        }

        for(Integer i : toFind){
            bstTree.contains(i);
            twoFourTree.find(i);
            rbTree.get(i);
        }

        try(BufferedWriter output = new BufferedWriter(new FileWriter("data.txt", true))){
            output.write(info + '\n');
            output.write("Ilosc liczb: " + size + '\n' + "Ilosc_porownan\n");
            output.write("\tBST: " + rbTree.getCompares() + '\n');
            output.write("\tRBTree: " + bstTree.getCompares() + '\n');
            output.write("\tTwoFourTree: " + twoFourTree.getCompares() + "\n\n\n");
            output.flush();
        } catch(IOException e){
            System.out.println("Failed to open file.");
        }
    }

    private static void resetCompares(){
        RbTree.resetCompares();
        TwoFourTree.resetCompares();
        BST.resetCompares();
    }
}
