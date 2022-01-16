package zad2;

public class Main {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();

        System.out.println("Początkowy rozmiar stosu: " + stack.size());

        //Testowanie powiększania stosu i dodawania nowych elementów
        stack.push(45);
        stack.push(12);
        stack.push(60);
        stack.push(50);
        stack.push(30);
        stack.push(89);
        stack.push(6456);
        stack.push(23410);

        //Operacja top, która tylko zwraca element
        System.out.println("\nZwracanie elementu na szczycie:");
        System.out.println(stack.top());
        System.out.println(stack.top());
        System.out.println(stack.top());

        //Testowanie usuwania elementów i zmniejszania jego wielkości
        System.out.println("\nOperacje usuwania ze stosu:");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("Próba wyciągnięcia elementu z pustego stosu: ");
        try{
            stack.pop();
        } catch (EmptyStackException e){
            System.out.println("Stos jest pusty!");
        }
    }
}
