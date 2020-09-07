// Challenge: Give a string with repeating characters (i.e. "aaabb") write
// an algorithm that will compress the string down to the character, followed
// by the number of times it appears in the string (i.e "a3b2").
// If the compressed string is not smaller than original, return original.


public class Compressor {
    public static void main(String[] args) {
        System.out.println(compress("aaabb"));
        System.out.println(compress("abcd"));
        System.out.println(compress("abbcccccccddaaaad"));
    }

    public static String compress(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            result.append(c);
            char nextChar = c;
            int letterCounter = 0;
            while (c == nextChar) {
                ++letterCounter;
                if (i + letterCounter < str.length()) {
                    nextChar = str.charAt(i + letterCounter);
                } else {
                    break;
                }
            }
            if (letterCounter > 1) {
                i += letterCounter;
                result.append(letterCounter);
            } else {
                i++;
            }
        }
        return result.toString();
    }
}
