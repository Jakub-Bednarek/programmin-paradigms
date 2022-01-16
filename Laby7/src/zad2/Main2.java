package zad2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        TestData linearData = new TestData();
        for(int i = 0; i < 100; i++){
            linearTest(linearData);
        }

        System.out.println("Test dla 100 wyszukań liniowych, tablica 1000 elementów, liczby z przedziału 1-1000");
        System.out.println("Liczba wyszukań trafionych: " + linearData.getFoundNumbers() + " średnia liczba porównań: " + linearData.getFoundComparesAverage());
        System.out.println("Liczba wyszukań nietrafionych: " + linearData.getNotFoundNumbers() + " średnia liczba porównań: " + linearData.getNotFoundComparesAverage());
        System.out.println("Łączna średnia liczba porównań dla przypatków trafionych i nietrafionych: " + linearData.getAverageCompares());

        TestData binaryData = new TestData();
        for(int i = 0; i < 100; i++){
            binaryTest(binaryData);
        }

        System.out.println("\nTest dla 100 wyszukań binarnych, tablica 1000 elementów, liczby z przedziału 1-1000");
        System.out.println("Liczba wyszukań trafionych: " + binaryData.getFoundNumbers() + " średnia liczba porównań: " + binaryData.getFoundComparesAverage());
        System.out.println("Liczba wyszukań nietrafionych: " + binaryData.getNotFoundNumbers() + " średnia liczba porównań: " + binaryData.getNotFoundComparesAverage());
        System.out.println("Łączna średnia liczba porównań dla przypatków trafionych i nietrafionych: " + binaryData.getAverageCompares());

        System.out.println("\nŁączna średnia liczba porównań dla wyszukiwania liniowego i binarnego: " + (linearData.getAverageCompares() + binaryData.getAverageCompares()) / 2);
    }

    public static void linearTest(TestData data){
        ArrayList<Integer> array = new ArrayList<>();

        ArrayOperations.fillWithRandomNumbers(array, 1000, 1000);
        int numberToFind = new Random().nextInt(1000);

        ArrayOperations.linearSearch(array, numberToFind, data);
    }

    public static void binaryTest(TestData data){
        ArrayList<Integer> array = new ArrayList<>();

        ArrayOperations.fillWithRandomNumbers(array, 1000, 1000);
        ArrayOperations.bubbleSort(array);
        int numberToFind = new Random().nextInt(1000);

        ArrayOperations.binarySearch(array, numberToFind, data);
    }
}
