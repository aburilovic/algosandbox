import java.util.*;

public class CountSubTrees {
    public static void main(String[] args) {
        //int n = 7;
        //int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        //String labels = "abaedcd";
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {3, 4}, {4, 5}};
        String labels = "cbabaa";
        int[] result = countSubTrees(n, edges, labels);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static final HashMap<String, Integer> alreadyCalculated = new HashMap<>();

    public static int[] countSubTrees(int n, int[][] edges, String labels) {
        final List<Integer>[] edgesArrayList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edgesArrayList[i] = new ArrayList<Integer>();
        }

        boolean[] nodesUsed = new boolean[n];
        nodesUsed[0] = true;

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (nodesUsed[edge[0]]) {
                edgesArrayList[edge[0]].add(edge[1]);
            } else {
                edgesArrayList[edge[1]].add(edge[0]);
            }
            nodesUsed[edge[0]] = true;
            nodesUsed[edge[1]] = true;
        }

        int[] result = new int[n];
        for (int i = 0; i < result.length; i++) {
            result[i] = labelCount(edgesArrayList, i, labels.charAt(i), labels);
        }
        return result;
    }

    public static int labelCount(List<Integer>[] edgesArrayList, int currentNode, char label, String labels) {
        int result = 0;
        if (labels.charAt(currentNode) == label) {
            result++;
        }
        List<Integer> edges = edgesArrayList[currentNode];
        if (edges.isEmpty()) {
            return result;
        }
        for (int i = 0; i < edges.size(); i++) {
            int count = 0;
            String key = "" + edges.get(i) + label;
            if (alreadyCalculated.containsKey(key)) {
                count = alreadyCalculated.get(key);
            } else {
                count = labelCount(edgesArrayList, edges.get(i), label, labels);
                alreadyCalculated.put(key, count);
            }
            result += count;
        }
        return result;
    }
}
