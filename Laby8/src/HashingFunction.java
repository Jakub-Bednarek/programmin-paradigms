public class HashingFunction {
    public static int hash(int key){
        int hashValue = 0;

        int copy = key;
        int number;
        while(copy > 0){
            number = copy % 10;
            copy /= 10;
            hashValue += number;
            hashValue *= number;
        }

        hashValue *= key;
        hashValue /= 3;

        return hashValue;
    }
}
