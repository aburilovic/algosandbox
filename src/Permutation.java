// check if entered string is permutation of another
public class Permutation {
    public static void main(String[] args) {
        System.out.println(isPermutation("ab", "ba"));
        System.out.println(isPermutation("aba", "ba"));
        System.out.println(isPermutation("cccsadsa", null));
        System.out.println(isPermutation("cccsadsa", "ccdsadsa"));
        System.out.println(isPermutation("aabbcc", "ccbbaa"));
    }

    static boolean isPermutation(String s1, String s2) {
        if (s1 == null || s2 == null || (s1.length() != s2.length())) {
            return false;
        }
        int startingIndex=0;
        int endingIndex = s1.length()-1;
        boolean result = true;
        while (startingIndex < endingIndex) {
            if (s1.charAt(startingIndex) != s2.charAt(endingIndex)) {
                result = false;
                break;
            } else {
                startingIndex++;
                endingIndex--;
            }
        }
        return result;
    }
}
