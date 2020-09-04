import java.util.HashMap;

public class RomanToInteger {

    private static HashMap<Character, Integer> romanLetters = new HashMap<>();
    private static HashMap<String, Integer> specialCases = new HashMap<>();

    public static void main(String[] args) {
        romanLetters.put('I', 1);
        romanLetters.put('V', 5);
        romanLetters.put('X', 10);
        romanLetters.put('L', 50);
        romanLetters.put('C', 100);
        romanLetters.put('D', 500);
        romanLetters.put('M', 1000);

        specialCases.put("IV", 4);
        specialCases.put("IX", 9);
        specialCases.put("XL", 40);
        specialCases.put("XC", 90);
        specialCases.put("CD", 400);
        specialCases.put("CM", 900);

        String roman = "DCXXI";
        System.out.println(romanToInt(roman));
    }

    public static int romanToInt(String s) {
        int totalSum = 0;
        for (int i = 0; i < s.length(); i++) {
            //case for two letters
            if (i <= s.length() - 2) {
                char firstLetter = s.charAt(i);
                char secondLetter = s.charAt(i + 1);

                String possibleSpecialCase = "" + firstLetter + secondLetter;
                Integer possibleValue = specialCases.get(possibleSpecialCase);

                if (possibleValue != null) {
                    totalSum += possibleValue.intValue();
                    i++;
                } else {
                    totalSum += romanLetters.get(firstLetter);
                }
            } else {
                totalSum += romanLetters.get(s.charAt(i));
            }
        }
        return totalSum;
    }
}
