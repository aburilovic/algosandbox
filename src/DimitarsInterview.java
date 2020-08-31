import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/*

Write a method that takes a string input and will return the first
character in a string which only appears once.
For example: It returns "b" when the input is "abaccdeff"
TIME LIMIT: 20 minutes
*/
public class DimitarsInterview {

    public static void main(String[] args) {

        String input = "aabccd";

        HashMap<Character, Integer> map = new LinkedHashMap<>();

        for (Character letter : input.toCharArray()) {
            int noOfOccurences = map.get(letter) == null ? 0 : map.get(letter);
            map.put(letter, ++noOfOccurences);
        }

        Optional<Map.Entry<Character, Integer>> opt = map.entrySet()
                .stream()
                .filter(p ->
                        p.getValue() == 1
                )
                .findFirst();
        if (opt.isPresent()) {
            System.out.println(opt.get().getKey());
        } else {
            System.out.println("N/A");
        }
    }
}
