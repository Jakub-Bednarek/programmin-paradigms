import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        BST<Integer> bst = new BST<>(new IntegerComparator());
        Scanner input = new Scanner(System.in);
        int choice = 1;

        while(choice != 14){
            printMenu();

            System.out.print("Wybór: ");
            choice = input.nextInt();

            switch(choice){
                case 1 -> insert(bst, input);
                case 2 -> bst.printPreOrder();
                case 3 -> bst.printInOrder();
                case 4 -> bst.printPostOrder();
                case 5 -> deleteNode(bst, input);
                case 6 -> findNode(bst, input);
                case 7 -> System.out.println("Wartość minimalna: " + bst.getMin());
                case 8 -> System.out.println("Wartość maksymalna: " + bst.getMax());
                case 9 -> findSuccessor(bst, input);
                case 10 -> findPredecessor(bst, input);
                case 11 -> bst.print();
                case 12 -> bst.printHorizontally();
                case 13 -> writeDataToNodes(bst);
                default -> {
                    continue;
                }
            }
        }
    }

    public static void printMenu(){
        System.out.println("\n----Dostępne opcje----");
        System.out.println("1. Wstaw węzeł.");
        System.out.println("2. Wypisz pre-order.");
        System.out.println("3. Wypisz in-order.");
        System.out.println("4. Wypisz post-order.");
        System.out.println("5. Usuń węzeł.");
        System.out.println("6. Znajdź węzeł.");
        System.out.println("7. Wyświetl klucz minimalny.");
        System.out.println("8. Wyświetl klucz maksymalny.");
        System.out.println("9. Znajdź następnika.");
        System.out.println("10. Znajdź poprzednika.");
        System.out.println("11. Narysuj drzewo(korzeń po lewej stronie, liście po prawej).");
        System.out.println("12. Wyświetl klucze poziomami.");
        System.out.println("13. Wyznacz i wpisz wysokość i liczbę węzłów dla każdego poddrzewa.");
        System.out.println("14. Zakończ program.");
    }

    public static void insert(BST tree, Scanner input){
        System.out.print("Klucz do wstawienia: ");
        int key = input.nextInt();

        tree.insert(key);
    }

    public static void deleteNode(BST tree, Scanner input){
        System.out.print("Klucz do usuniecia: ");
        int key = input.nextInt();

        tree.delete(key);
    }

    public static void findNode(BST tree, Scanner input){
        System.out.print("Klucz do znalezienia: ");
        int key = input.nextInt();

        System.out.println("Węzeł o podanym kluczu: " + tree.contains(key));
    }

    public static void findPredecessor(BST tree, Scanner input){
        System.out.print("Klucz węzła do znalezienia poprzednika: ");
        int key = input.nextInt();

        System.out.println("Następnik węzła o kluczu " + key + ": " + tree.findPredecessor(key));
    }

    public static void findSuccessor(BST tree, Scanner input){
        System.out.print("Klucz węzła do znalezienia następnika: ");
        int key = input.nextInt();

        System.out.println("Następnik węzła o kluczu " + key + ": " + tree.findSuccessor(key));
    }

    public static void writeDataToNodes(BST tree){
        tree.writeHeightForEveryNode();
        tree.writeNodesForEveryNode();
    }
}
