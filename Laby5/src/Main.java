import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Car[] cars = new Car[9];
        cars[0] = new Car("Mercedes", "Red", 1995);
        cars[1] = new Car("Audi", "Blue", 1997);
        cars[2] = new Car("Nissan", "Green", 1995);
        cars[3] = new Car("Toyota", "Brown", 2005);
        cars[4] = new Car("Porshe", "Albino", 2001);
        cars[5] = new Car("Porshe", "Albino", 2005);
        cars[6] = new Car("Nissan", "Blue", 1998);
        cars[7] = new Car("Audi", "Albino", 1997);
        cars[8] = new Car("Mercedes", "Red", 1985);
        printCarsArray(cars);

        System.out.println("\n*SORTING ALL VALUES IN ASCENDING ORDER*\n*Insertion sort algorithm*\nSorting by type:");
        InsertionSort inSort = new InsertionSort(new Car.CarTypeComparator());
        inSort.sort(cars);
        printCarsArray(cars);

        System.out.println("\nSorting by color:");
        inSort.setComparator(new Car.CarColorComparator());
        inSort.sort(cars);
        printCarsArray(cars);

        System.out.println("\nSorting by year:");
        inSort.setComparator(new Car.CarYearComparator());
        inSort.sort(cars);
        printCarsArray(cars);

        System.out.println("\n*Selection sort algorithm*\nSorting by type:");
        SelectionSort selSort = new SelectionSort(new Car.CarTypeComparator());
        selSort.sort(cars);
        printCarsArray(cars);

        System.out.println("\nSorting by color:");
        selSort.setComparator(new Car.CarColorComparator());
        selSort.sort(cars);
        printCarsArray(cars);

        System.out.println("\nSorting by year:");
        selSort.setComparator(new Car.CarYearComparator());
        selSort.sort(cars);
        printCarsArray(cars);

        ComplexComparator<Car> complex = new ComplexComparator<>();
        complex.addComparator(new Car.CarTypeComparator());
        complex.addComparator(new Car.CarColorComparator());
        complex.addComparator(new Car.CarYearComparator());
        System.out.println("\nInsertion sort with complex comparator:");
        inSort.setComparator(complex);
        inSort.sort(cars);
        printCarsArray(cars);

        System.out.println("\nSelection sort with complex comparator:");
        selSort.setComparator(complex);
        selSort.sort(cars);
        printCarsArray(cars);

        System.out.println("\nInsertion sort with big complex comparator");
        inSort.setComparator(new Car.BigComplexComparator());
        inSort.sort(cars);
        printCarsArray(cars);

        System.out.println("\nSelection sort with big complex comparator:");
        selSort.setComparator(new Car.BigComplexComparator());
        selSort.sort(cars);
        printCarsArray(cars);
    }

    public static void printCarsArray(Car[] cars){
        for(Car c : cars){
            System.out.println(c);
        }
    }

    public static class ComplexComparator<T> implements Comparator<T> {
        private final List<Object> comparators = new ArrayList<>();

        public void addComparator(Comparator<T> comparator){
            comparators.add(comparator);
        }

        @Override
        public int compare(T t1, T t2){
            int result = 0;

            for(Object o : comparators){
                Comparator<T> comp = (Comparator<T>)o;
                result = comp.compare(t1, t2);

                if(result != 0) break;
            }

            return result;
        }
    }
}
