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
        int[] scores = {295, 294, 291, 287, 287, 285, 285, 284, 283, 279, 277, 274, 274, 271, 270, 268, 268, 268, 264, 260, 259, 258, 257, 255, 252, 250, 244, 241, 240, 237, 236, 236, 231, 227, 227, 227, 226, 225, 224, 223, 216, 212, 200, 197, 196, 194, 193, 189, 188, 187, 183, 182, 178, 177, 173, 171, 169, 165, 143, 140, 137, 135, 133, 130, 130, 130, 128, 127, 122, 120, 116, 114, 113, 109, 106, 103, 99, 92, 85, 81, 69, 68, 63, 63, 63, 61, 57, 51, 47, 46, 38, 30, 28, 25, 22, 15, 14, 12, 6, 4};
        int[] alices = {5, 5, 6, 14, 19, 20, 23, 25, 29, 29, 30, 30, 32, 37, 38, 38, 38, 41, 41, 44, 45, 45, 47, 59, 59, 62, 63, 65, 67, 69, 70, 72, 72, 76, 79, 82, 83, 90, 91, 92, 93, 98, 98, 100, 100, 102, 103, 105, 106, 107, 109, 112, 115, 118, 118, 121, 122, 122, 123, 125, 125, 125, 127, 128, 131, 131, 133, 134, 139, 140, 141, 143, 144, 144, 144, 144, 147, 150, 152, 155, 156, 160, 164, 164, 165, 165, 166, 168, 169, 170, 171, 172, 173, 174, 174, 180, 184, 187, 187, 188, 194, 197, 197, 197, 198, 201, 202, 202, 207, 208, 211, 212, 212, 214, 217, 219, 219, 220, 220, 223, 225, 227, 228, 229, 229, 233, 235, 235, 236, 242, 242, 245, 246, 252, 253, 253, 257, 257, 260, 261, 266, 266, 268, 269, 271, 271, 275, 276, 281, 282, 283, 284, 285, 287, 289, 289, 295, 296, 298, 300, 300, 301, 304, 306, 308, 309, 310, 316, 318, 318, 324, 326, 329, 329, 329, 330, 330, 332, 337, 337, 341, 341, 349, 351, 351, 354, 356, 357, 366, 369, 377, 379, 380, 382, 391, 391, 394, 396, 396, 400};
        int[] result = climbingLeaderboard(scores, alices);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
