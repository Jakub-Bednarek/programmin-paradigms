import java.util.Comparator;

public class Car {
    private String type;
    private String color;
    private int productionYear;

    public Car(String type, String color, int productionYear) {
        this.type = type;
        this.color = color;
        this.productionYear = productionYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    @Override
    public String toString() {
        return "[" + type + ", " + color + ", " + productionYear + "]";
    }

    public static class BigComplexComparator implements Comparator<Car> {
        @Override
        public int compare(Car c1, Car c2) {
            int comp = c1.type.compareTo(c2.type);

            if(comp == 0){
                comp = c1.color.compareTo(c2.color);
            }

            if(comp == 0){
                comp = c1.productionYear - c2.productionYear;
            }

            return comp;
        }
    }

    public static class CarTypeComparator implements Comparator<Car> {
        @Override
        public int compare(Car o1, Car o2) {
            return o1.getType().compareTo(o2.getType());
        }
    }

    public static class CarColorComparator implements Comparator<Car> {
        @Override
        public int compare(Car o1, Car o2) {
            return o1.getColor().compareTo(o2.getColor());
        }
    }

    public static class CarYearComparator implements Comparator<Car> {
        @Override
        public int compare(Car o1, Car o2) {
            return o1.getProductionYear() - o2.getProductionYear();
        }
    }
}
