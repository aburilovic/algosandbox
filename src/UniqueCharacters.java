
// Challenge: Given a string, see if you can detect whether it contains only
// unique chars

public class UniqueCharacters {
    public static void main(String[] args) {
        System.out.println(isUnique("ab"));
        System.out.println(isUnique("aa"));
        System.out.println(isUnique("abcdefghijklmnopqrstauvwxyz"));
    }

    public static boolean isUnique(String s) {
        boolean unique = true;
        int chars[] = new int[255];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (chars[c] > 0) {
                unique = false;
                break;
            } else {
                chars[c]++;
            }
        }
        return unique;
    }
}
