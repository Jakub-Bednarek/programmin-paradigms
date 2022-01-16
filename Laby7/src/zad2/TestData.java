package zad2;

public class TestData {
    private int foundNumbers = 0;
    private int foundCompares = 0;
    private int notFoundNumbers = 0;
    private int notFoundCompares = 0;
    private int testCases = 0;

    public int getAverageCompares() throws ArithmeticException {
        if(testCases == 0){
            throw new ArithmeticException();
        }

        return (foundCompares + notFoundCompares) / testCases;
    }

    public int getFoundComparesAverage(){
        if(testCases == 0){
            throw new ArithmeticException();
        }

        return foundCompares / foundNumbers;
    }

    public int getNotFoundComparesAverage(){
        if(testCases == 0){
            throw new ArithmeticException();
        }

        return notFoundCompares / notFoundNumbers;
    }

    public int getFoundNumbers(){
        return foundNumbers;
    }

    public int getNotFoundNumbers(){
        return notFoundNumbers;
    }

    public void incrementTestCases(){
        testCases++;
    }

    public void incrementFoundNumbers(){
        this.foundNumbers++;
    }

    public void incrementNotFoundNumbers(){
        this.notFoundNumbers++;
    }

    public void addFoundCompares(int value){
        this.foundCompares += value;
    }

    public void addNotFoundCompares(int value){
        this.notFoundCompares += value;
    }
}
