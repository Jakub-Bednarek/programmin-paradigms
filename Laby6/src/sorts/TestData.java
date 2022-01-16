package sorts;

public class TestData {
    private int compares = 0;
    private int switches = 0;

    public int getCompares() {
        return compares;
    }

    public void incCompares(int toAdd) {
        this.compares += toAdd;
    }

    public int getSwitches() {
        return switches;
    }

    public void incSwitches(int toAdd) {
        this.switches += toAdd;
    }
}
