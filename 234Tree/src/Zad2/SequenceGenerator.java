package Zad2;

import java.util.*;

public class SequenceGenerator {
    public static Set<Integer> generateRandomList(int size, int upper){
        Random generator = new Random();

        Set<Integer> list = new HashSet<>();
        while(list.size() < size){
            list.add(generator.nextInt(upper));
        }

        return list;
    }
}
