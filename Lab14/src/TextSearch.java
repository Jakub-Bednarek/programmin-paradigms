public class TextSearch {
    public static void knuthMorrisSearch(String pattern, String textToSearch){
        int patterL = pattern.length();
        int textL = textToSearch.length();
        int iloscWystapien = 0;

        int[] lps = new int[patterL];
        int j = 0;

        getLongestProperSuffix(pattern, patterL, lps);

        int i = 0;
        while (i < textL){
            if(pattern.charAt(j) == textToSearch.charAt(i)){
                j++;
                i++;
            }

            if(j == patterL){
                System.out.println("Znaleziono wzorzec o początku z indeksem: " + (i - j));
                j = lps[j - 1];
                iloscWystapien++;
            } else if(i < textL && pattern.charAt(j) != textToSearch.charAt(i)){
                if(j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }

        System.out.println("Wzorzec \"" + pattern + "\" wystąpił w tekście " + iloscWystapien + " razy.");
    }

    public static void getLongestProperSuffix(String pattern, int patternL, int lps[]){
        int length = 0;
        int i = 1;
        lps[0] = 0;

        while(i < patternL){
            if(pattern.charAt(i) == pattern.charAt(length)){
                length++;
                lps[i] = length;
                i++;
            } else{
                if(length != 0)
                    length = lps[length - 1];
                else {
                    lps[i] = length;
                    i++;
                }
            }
        }
    }
}
