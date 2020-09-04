import java.util.Arrays;
import java.util.HashMap;

// check if entered string is permutation of another
public class Permutation {
    public static void main(String[] args) {
        System.out.println(isPermutation2("ab", "ba"));
        System.out.println(isPermutation2("aba", "ba"));
        System.out.println(isPermutation2("cccsadsa", null));
        System.out.println(isPermutation2("cccsadsa", "ccdsadsa"));
        System.out.println(isPermutation2("aabbcc", "cbcbaa"));
    }

    static boolean isPermutation1(String s1, String s2) {
        if (s1 == null || s2 == null || (s1.length() != s2.length())) {
            return false;
        }
        char first[] = s1.toCharArray();
        char second[] = s2.toCharArray();

        Arrays.sort(first);
        Arrays.sort(second);

        boolean result = true;
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                result = false;
                break;
            }
        }
        return result;
    }

    static boolean isPermutation2(String s1, String s2) {
        if (s1 == null || s2 == null || (s1.length() != s2.length())) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        for (int i = 0; i < s1.length(); i++) {
            Integer value = map1.get(s1.charAt(i));
            if (value == null) {
                value = Integer.valueOf(0);
            }
            map1.put(s1.charAt(i), value.intValue() + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            Integer value = map2.get(s2.charAt(i));
            if (value == null) {
                value = Integer.valueOf(0);
            }
            map2.put(s2.charAt(i), value.intValue() + 1);
        }

        boolean result = true;
        for (int i = 0; i < s1.length(); i++) {
            Integer value1 = map1.get(s1.charAt(i));
            Integer value2 = map2.get(s1.charAt(i));
            if (value2 == null || value1.intValue() != value2.intValue()) {
                result = false;
                break;
            }
        }
        return result;
    }
}
