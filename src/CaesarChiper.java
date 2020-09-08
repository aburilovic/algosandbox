// In cryptography, a Caesar cipher, also known as Caesar's cipher, the shift cipher, Caesar's code or Caesar shift, is one of the simplest and most widely known encryption techniques.
// It is a type of substitution cipher in which each letter in the plaintext is replaced by a letter some fixed number of positions down the alphabet.
// For example, with a left shift of 3, D would be replaced by A, E would become B, and so on. The method is named after Julius Caesar, who used it in his private correspondence.

public class CaesarChiper {
    public static void main(String[] args) {
        System.out.println(chiper("ZAH", 3, true));
        System.out.println(chiper("GHJZA", 3, false));
    }

    private static String chiper(String input, int offset, boolean refactor) {
        int mod = 'Z' + 1;
        int start = 'A';
        int range = mod - start;
        offset = offset % range;
        input = input.toUpperCase();

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                stringBuilder.append(input.charAt(i));
                continue;
            }
            int resultLetter;
            if (refactor) {
                resultLetter = (input.charAt(i) + offset) % mod;
                if (resultLetter < start) {
                    resultLetter += start;
                }
            } else {
                resultLetter = (input.charAt(i) - offset) % mod;
                if (resultLetter < start) {
                    resultLetter += range;
                }
            }

            stringBuilder.append((char) resultLetter);
        }
        return stringBuilder.toString();
    }
}
