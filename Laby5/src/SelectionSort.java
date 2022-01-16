import java.util.Comparator;

public class SelectionSort<T> {
    Comparator<T> comparator;

    public SelectionSort(Comparator<T> comparator){
        this.comparator = comparator;
    }

    public void sort(T[] arrayToSort){
        for(int i = 0; i < arrayToSort.length; i++){
            int lowestValueIndex = i;
            for(int j = i + 1; j < arrayToSort.length; j++){
                if(comparator.compare(arrayToSort[j], arrayToSort[lowestValueIndex]) < 0)
                    lowestValueIndex = j;
            }

            T temp = arrayToSort[i];
            arrayToSort[i] = arrayToSort[lowestValueIndex];
            arrayToSort[lowestValueIndex] = temp;
        }
    }

    public void setComparator(Comparator<T> comparator){
        this.comparator = comparator;
    }
}
