package sorts;

public class QuickSort implements Sort {
    TestData data;
    @Override
    public String getName() { return "QuickSort";}

    @Override
    public TestData sort(int[] array) {
        data = new TestData();
        quickSort(array, 0, array.length - 1);

        return data;
    }

    private void quickSort(int[] array, int low, int high){
        if(low < high)
        {
            int part = partition(array, low, high);
            data.incCompares(1);

            quickSort(array, low, part - 1);
            quickSort(array, part + 1, high);
        }
    }

    private int partition(int[] array, int low, int high){
        int pivot = array[high];
        int i = low - 1;

        for(int j = low; j <= high - 1; j++){
            if(array[j] < pivot){
                data.incCompares(1);
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);

        return i +1;
    }

    private void swap(int[] array, int firstInd, int secondInd){
        int temp = array[firstInd];
        array[firstInd] = array[secondInd];
        array[secondInd] = temp;

        data.incSwitches(3);
    }
}
