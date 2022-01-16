package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    private static Random generator = new Random();

    public static int[] generateRandom(int size) {
        int[] arr = new int[size];

        for(int i = 0; i < size; i++){
            arr[i] = generator.nextInt(10000);
        }

        return arr;
    }

    public static int[] generateInOrder(int size, boolean ascending){
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < size; i++){
            list.add(generator.nextInt(10000));
        }

        if(!ascending)
            Collections.sort(list, Collections.reverseOrder());
        else
            Collections.sort(list);

        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = list.get(i);
        }

        return arr;
    }
}
