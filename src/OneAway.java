// Challenge: There are three types of edits that can be performed on strings:
// insert a character,
// remove a character,
// replace a character.
//
// Given two strings, write a function to check if they are
// one or zero edits away.

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

public class OneAway {
    public static void main(String[] args) {
        System.out.println(oneAway("pale", "paleXXXX"));
        System.out.println(oneAway("pale", "ple"));
        System.out.println(oneAway("pales", "pale"));
        System.out.println(oneAway("pale", "bale"));
        System.out.println(oneAway("pale", "bake"));
        System.out.println(oneAway("pale", "aale"));
        System.out.println(oneAway("pale", "lape"));
        System.out.println(oneAway("ABCD", "BCDAG"));
        System.out.println(oneAway("ABCD", "ABDC"));
    }

    static boolean oneAway(String input, String output) {

        if (Math.abs(input.length() - output.length()) > 1) {
            return false;
        }

        if (input.length() == output.length()) {
            int difference = 0;
            for (int i = 0; i < input.length(); i++) {
                char c1 = input.charAt(i);
                char c2 = output.charAt(i);

                if (c1 != c2) {
                    difference++;
                    if (difference > 1) {
                        break;
                    }
                }
            }
            return difference <= 1;
        }

        String longerString = input.length() > output.length() ? input : output;
        String shorterString = input.length() < output.length() ? input : output;
        int counterShorter = 0;
        int counterLonger = 0;
        int charactersDeleted = 0;
        while (counterShorter < shorterString.length()) {
            char c1 = shorterString.charAt(counterShorter);
            char c2 = longerString.charAt(counterLonger);

            if (c1 != c2) {
                charactersDeleted++;
                counterLonger++;
                if (charactersDeleted > 1) {
                    break;
                }
            } else {
                counterShorter++;
                counterLonger++;
            }
        }
        return charactersDeleted <=1;
    }
}
