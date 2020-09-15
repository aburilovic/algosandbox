import java.util.Arrays;
import java.util.List;

public class VeryBigSum {
    public static void main(String[] args) {
        final long[] arr = {1000000001, 1000000002, 1000000003, 1000000004, 1000000005};
        System.out.println(aVeryBigSum(arr));
    }

    public static long aVeryBigSum(long[] ar) {
        long result = 0;
        for (int i = 0; i < ar.length; i++) {
            result += ar[i];
        }
        return result;
    }
}
