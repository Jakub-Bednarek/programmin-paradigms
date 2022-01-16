import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Jako tekst do testów w pliku pan-tadeusz.txt znajduje się cała zawartość książki na podstawie której można sprawdzać wystąpienia.");

        String pattern = null;
        String text = null;
        boolean initialized = false;
        boolean finished = false;
        int choice = 0;
        while(!finished){
            printMenu();
            System.out.print("Wybór: ");

            try{
                choice = input.nextInt();
                input.nextLine();

                switch(choice){
                    case 1:
                        text = readText(input);
                        break;
                    case 2:
                        System.out.print("Tekst: ");
                        text = input.nextLine();
                        break;
                    case 3:
                        System.out.print("Wzorzec do wyszukania: ");
                        pattern = input.nextLine();
                        break;
                    case 4:
                        if(text != null && pattern != null)
                            TextSearch.knuthMorrisSearch(pattern, text);
                        else
                            System.out.println("\n---!!!Tekst lub wzorzez do wyszukania są puste!!!---\n");
                        break;
                    case 5:
                        finished = true;
                        break;
                    default:
                        System.out.println("Nie ma takiej opcji!");
                        break;
                }
            } catch(InputMismatchException e){
                System.out.println("Niepoprawny typ danych!");
            }
        }
    }

    public static void printMenu(){
        System.out.println("\nDostępne opcje:");
        System.out.println("1. Wczytaj plik");
        System.out.println("2. Wczytaj własny tekst z klawiatury");
        System.out.println("3. Wczytaj wzorzec do wyszukania");
        System.out.println("4. Wyszukaj wzorzec w tekście(wymaga załadowanego tekstu i wzorca)");
        System.out.println("5. Zakończ program");
    }

    public static String readText(Scanner input){
        StringBuffer text = new StringBuffer();
        System.out.print("Nazwa pliku tekstowego: ");
        String filePath = input.nextLine();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){

            String line;
            while((line = reader.readLine()) != null){
                text.append(line);
            }
        } catch(IOException e){
            System.out.println("Failed to open file!");
        }

        return text.toString();
    }
}
