

public class LongestCommonSequence {

    public static void main(String[] args) {
        String input1 = "AGGTAAAAB";
        String input2 = "GXTXAYBA";

        int[] letterOccuranceArray1 = new int[255];
        int[] visitedArray2 = new int[255];

        char[] chars1 = input1.toCharArray();
        char[] chars2 = input2.toCharArray();

        for (int i = 0; i < chars1.length; i++) {
            letterOccuranceArray1[chars1[i]]++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars2.length; i++) {
            char c = chars2[i];
            int occurance1 = letterOccuranceArray1[chars2[i]];
            int visitedNo = visitedArray2[chars2[i]];
            if (occurance1 > 0 && occurance1 > visitedNo) {
                visitedArray2[chars2[i]]++;
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}
