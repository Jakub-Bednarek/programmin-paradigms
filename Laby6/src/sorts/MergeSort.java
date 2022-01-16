package sorts;

public class MergeSort implements Sort {
    TestData data;
    @Override
    public String getName() { return "MergeSort"; }

    @Override
    public TestData sort(int[] array) {
        data = new TestData();
        mergeSort(array, 0, array.length - 1);
        return data;
    }

    private void mergeSort(int[] array, int low, int high){
        if (high <= low)
        {
            data.incCompares(1);
            return;
        }

        int middle = (low + high) / 2;

        mergeSort(array, low, middle);
        mergeSort(array, middle + 1, high);

        merge(array, low, middle, high);
    }

    private void merge(int[] array, int low, int middle, int high){
        int[] left = new int[middle - low + 1];
        int[] right = new int[high - middle];

        for(int i = 0; i < left.length; i++)
        {
            left[i] = array[low + i];
            data.incSwitches(1);
        }
        for(int i = 0; i < right.length; i++)
        {
            right[i] = array[middle + i + 1];
            data.incSwitches(1);
        }

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = low; i < high + 1; i++) {
            if (leftIndex < left.length && rightIndex < right.length) {
                if (left[leftIndex] < right[rightIndex]) {
                    array[i] = left[leftIndex];
                    data.incSwitches(1);
                    data.incCompares(1);
                    leftIndex++;
                } else {
                    array[i] = right[rightIndex];
                    data.incSwitches(1);
                    rightIndex++;
                }
            } else if (leftIndex < left.length) {
                array[i] = left[leftIndex];
                data.incSwitches(1);
                data.incCompares(1);
                leftIndex++;
            } else if (rightIndex < right.length) {
                array[i] = right[rightIndex];
                data.incSwitches(1);
                data.incCompares(1);
                rightIndex++;
            }
        }
    }
}
