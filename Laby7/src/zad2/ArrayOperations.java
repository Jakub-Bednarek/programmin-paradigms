package zad2;

import java.util.ArrayList;
import java.util.Random;

public class ArrayOperations {
    public static void fillWithRandomNumbers(ArrayList<Integer> array, int size, int maxRange){
        Random generator = new Random();

        for(int i = 0; i < size; i++){
            array.add(generator.nextInt(maxRange));
        }
    }

    public static int linearSearch(ArrayList<Integer> array, int element, TestData data){
        int compares = 0;

        data.incrementTestCases();

        for(int i = 0; i < array.size(); i++){
            if(array.get(i).equals(element)){
                data.addFoundCompares(compares);
                data.incrementFoundNumbers();
                return i;
            }
            compares++;
        }

        data.addNotFoundCompares(compares);
        data.incrementNotFoundNumbers();
        return -1;
    }

    public static void bubbleSort(ArrayList<Integer> array){
        boolean sorted = false;

        while(!sorted){
            sorted = true;

            for(int i = 0; i < array.size() - 1; i++){
                if(array.get(i) > array.get(i + 1)){
                    swap(array, i, i + 1);
                    sorted = false;
                }
            }
        }
    }

    public static void swap(ArrayList<Integer> array, int left, int right){
        int temp = array.get(left);
        array.set(left, array.get(right));
        array.set(right, temp);
    }

    public static int binarySearch(ArrayList<Integer> array, int element, TestData data){
        int left = 0;
        int right = array.size() - 1;
        int middle;
        int compares = 0;

        data.incrementTestCases();

        while(left <= right){
            middle = (left + right) / 2;

            int compareVal = array.get(middle).compareTo(element);
            if(compareVal == 0){
                data.addFoundCompares(compares);
                data.incrementFoundNumbers();
                return middle;
            } else if(compareVal > 0){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            compares++;
        }

        data.addNotFoundCompares(compares);
        data.incrementNotFoundNumbers();
        return -1;
    }
}
