package sorts;

public class SelectionSort implements Sort {
    TestData data;
    @Override
    public String getName() { return "SelectionSort"; }

    @Override
    public TestData sort(int[] arrayToSort){
        data = new TestData();
        int lowestIntIndex = 0;
        int lowestIntValue = Integer.MAX_VALUE;

        for(int i = 0; i < arrayToSort.length; i++){
            for(int j = i; j < arrayToSort.length; j++){
                if(arrayToSort[j] < lowestIntValue){
                    lowestIntIndex = j;
                    lowestIntValue = arrayToSort[j];
                    data.incSwitches(2);
                }

                data.incCompares(1);
            }

            int temp = arrayToSort[i];
            arrayToSort[i] = lowestIntValue;
            arrayToSort[lowestIntIndex] = temp;
            data.incSwitches(3);
            lowestIntValue = Integer.MAX_VALUE;
        }

        return data;
    }
}
