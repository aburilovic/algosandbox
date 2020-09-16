public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder longestPrefix = new StringBuilder();
        if (strs != null && strs.length > 0 && strs[0].length() > 0) {
            int currentLetterIndex = 0;
            char currentLetter = strs[0].charAt(currentLetterIndex);
            boolean breakout = false;
            while (!breakout) {
                for (String str : strs) {
                    if (currentLetterIndex > str.length() - 1) {
                        breakout = true;
                        break;
                    }
                    if (currentLetter != str.charAt(currentLetterIndex)) {
                        breakout = true;
                        break;
                    }
                }
                if (!breakout) {
                    longestPrefix.append(currentLetter);
                }
                currentLetterIndex++;
                if (currentLetterIndex < strs[0].length()) {
                    currentLetter = strs[0].charAt(currentLetterIndex);
                }
            }
        }
        return longestPrefix.toString();
    }
}
