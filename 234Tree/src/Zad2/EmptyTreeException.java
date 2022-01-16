package Zad2;

public class EmptyTreeException extends RuntimeException{
    @Override
    public String toString() {
        return "EmptyTreeException - Root is empty!";
    }
}
