package main;

import sorts.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        pureDataTest();
    }

    public static void printArray(int[] arr){
        for(int i : arr){
            System.out.println(i);
        }
    }

    public static void pureDataTest(){
        Sort[] algos = new Sort[4];

        algos[0] = new InsertionSort();
        algos[1] = new SelectionSort();
        algos[2] = new QuickSort();
        algos[3] = new MergeSort();

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("PureScores.txt", true))){
            for(int i = 0; i < 4; i++){
                oneAlgoTest(writer, algos[i]);
            }
        } catch (IOException e){
            System.out.println("Failed to open file.");
        }
    }

    public static TestData[] simpleTest(int size, Sort algorithm){
        int[] arrayRandom = RandomGenerator.generateRandom(size);
        int[] arrayDescending = RandomGenerator.generateInOrder(size, false);
        int[] arrayAscending = RandomGenerator.generateInOrder(size, true);

        TestData[] scores = new TestData[3];

        scores[0] = algorithm.sort(arrayRandom);
        scores[1] = algorithm.sort(arrayDescending);
        scores[2] = algorithm.sort(arrayAscending);

        return scores;
    }

    public static void oneAlgoTest(BufferedWriter writer, Sort algorithm) throws IOException {
        int[] sizes = { 8, 32, 128, 512, 1024 };

        for(int i = 0; i < 5; i++){
            writer.write(algorithm.getName() + "\t" + sizes[i] + "\n");
            TestData[] data = simpleTest(sizes[i], algorithm);

            writer.write("Random\t" + data[0].getSwitches() + "\t" + data[0].getCompares() + "\n");
            writer.write("Ascending\t" + data[1].getSwitches() + "\t" + data[1].getCompares() + "\n");
            writer.write("Descending\t" + data[2].getSwitches() + "\t" + data[2].getCompares() + "\n");

            writer.flush();
        }
    }
}
