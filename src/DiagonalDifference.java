import java.util.Iterator;
import java.util.List;

public class DiagonalDifference {

    public static void main(String[] args) {

    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int nCounter = 0;
        int sum1 = 0;
        int sum2 = 0;
        Iterator<List<Integer>> iterN = arr.iterator();
        while (iterN.hasNext()) {
            List<Integer> mList = iterN.next();
            sum1 += mList.get(nCounter);
            sum2 += mList.get(arr.size() - 1 - nCounter);
            nCounter++;
        }
        return Math.abs(sum1 - sum2);
    }
}
