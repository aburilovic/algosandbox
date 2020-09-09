import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

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
            int diff = ((Score) o).score - this.score;
            if (diff == 0 && this.isAlice) {
                return -1;
            }
            return diff;
        }
    }

    // Complete the climbingLeaderboard function below.
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
        int aliceRankCounter = 0;

        for (int i = 0; i < totalScores.length; i++) {
            if (totalScores[i].isAlice) {
                result[aliceRankCounter] = mainCounter;
                aliceRankCounter++;
            } else {
                if (prev != totalScores[i].score) {
                    prev = totalScores[i].score;
                    mainCounter++;
                }
            }
        }

        int[] resultReversed = new int[alice.length];
        int smece = 0;
        for (int i = result.length - 1; i >= 0; i--) {
            resultReversed[smece] = result[i];
            smece++;
        }

        return resultReversed;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] scores = {100, 100, 50, 50, 40, 40, 20, 10};
        int[] alices = {5, 25, 50, 50, 50, 120};
        int[] result = climbingLeaderboard(scores, alices);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
