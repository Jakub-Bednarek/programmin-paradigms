import java.util.Comparator;

public class InsertionSort<T> {
    Comparator<T> comparator;

    public InsertionSort(Comparator<T> comparator){
        this.comparator = comparator;
    }

    public void sort(T[] arrayToSort){
        T valueToCompare = null;
        int j = 0;

        for(int i = 1; i < arrayToSort.length; i++){
            valueToCompare = arrayToSort[i];
            j = i - 1;

            while(j >= 0 && comparator.compare(valueToCompare, arrayToSort[j]) < 0){
                arrayToSort[j + 1] = arrayToSort[j];
                j--;
            }

            arrayToSort[j + 1] = valueToCompare;
        }
    }

    public void setComparator(Comparator<T> comparator){
        this.comparator = comparator;
    }
}
