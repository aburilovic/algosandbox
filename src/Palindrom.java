import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Palindrom {
    List<String> palindroms = new ArrayList<String>();

    public static void main(String[] args) {
        Palindrom palindrom = new Palindrom();
        String word = "anteeetcact";
        palindrom.checkWordPalindrom(word);

        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                palindrom.checkWordPalindrom(word.substring(i, j));
            }
        }
        palindrom.palindroms.forEach(p -> {
            System.out.println(p);
        });
    }


    private void checkWordPalindrom(String word) {
        if (word.length() == 1) {
            if (!palindroms.contains(word)) {
                palindroms.add(word);
            }
        } else {
            for (int i = 0; i < word.length() / 2; i++) {
                if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                    return;
                }
            }
        }
        if (!palindroms.contains(word)) {
            palindroms.add(word);
        }
    }
}
