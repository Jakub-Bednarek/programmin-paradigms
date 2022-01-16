package sorts;

public class InsertionSort implements Sort {
    TestData data;

    @Override
    public String getName() { return "InsertionSort"; }

    @Override
    public TestData sort(int[] arrayToSort){
        data = new TestData();
        int valueToCompare = 0;
        int j = 0;

        for(int i = 1; i < arrayToSort.length; i++){
            valueToCompare = arrayToSort[i];
            data.incSwitches(1);
            j = i - 1;

            moveElements(arrayToSort, valueToCompare, j);
        }

        return data;
    }

    private void moveElements(int[] arrayToSort, int valueToCompare, int indexJ){
        while(indexJ >= 0 && valueToCompare < arrayToSort[indexJ]){
            arrayToSort[indexJ + 1] = arrayToSort[indexJ];
            data.incSwitches(1);
            data.incCompares(1);
            indexJ--;
        }

        arrayToSort[indexJ + 1] = valueToCompare;
        data.incSwitches(1);
    }
}
