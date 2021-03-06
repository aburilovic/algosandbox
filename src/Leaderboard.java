import java.io.*;
import java.util.*;

public class Leaderboard {

    static class Score implements Comparable {
        public int score;
        public boolean isAlice;

        public Score(int score, boolean isAlice) {
            this.score = score;
            this.isAlice = isAlice;
        }

        @Override
        public int compareTo(Object o) {
            int firstScore = ((Score) o).score;
            int diff = firstScore - this.score;
            if (diff == 0) {
                boolean secondIsAlice = ((Score) o).isAlice;
                if (this.isAlice && !secondIsAlice) {
                    return -1;
                } else if (!this.isAlice && secondIsAlice) {
                    return 1;
                }
            }
            return diff;
        }
    }

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        Score[] totalScores = new Score[scores.length + alice.length];
        int scoresCounter = 0;
        int cnt = 0;
        while (cnt < scores.length) {
            totalScores[scoresCounter] = new Score(scores[cnt], false);
            cnt++;
            scoresCounter++;
        }
        cnt = 0;
        while (cnt < alice.length) {
            totalScores[scoresCounter] = new Score(alice[cnt], true);
            cnt++;
            scoresCounter++;
        }

        Arrays.sort(totalScores);

        int mainCounter = 1;
        int prev = 0;

        int[] result = new int[alice.length];
        int aliceRankCounter = alice.length - 1;

        for (int i = 0; i < totalScores.length; i++) {
            if (totalScores[i].isAlice) {
                result[aliceRankCounter] = mainCounter;
                aliceRankCounter--;
            } else {
                if (prev != totalScores[i].score) {
                    prev = totalScores[i].score;
                    mainCounter++;
                }
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] scores = {100, 100, 50, 40, 40, 20, 10};
        int[] alices = {5, 25, 50, 120};
        int[] result = climbingLeaderboard(scores, alices);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
