public class Anagram {




    public static void main(String[] args) {
        String str1 = "ana voli milovana";
        String str2 = "ana voli miolvana";

        int[] letters1 = new int[255];
        int[] letters2 = new int[255];

        if (str1.length() != str2.length()) {
            System.out.println("NO!!!!");
            return;
        }

        for (int i=0; i<str1.length(); i++) {
            letters1[str1.charAt(i)]++;
        }

        for (int i=0; i<str2.length(); i++) {
            letters2[str2.charAt(i)]++;
        }

        for (int i=0; i<str1.length(); i++) {
            if (letters1[str1.charAt(i)] != letters2[str1.charAt(i)]){
                System.out.println("NO!!!!");
                return;
            }
        }
        System.out.println("YES!!!!");

    }

}
