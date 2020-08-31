
// UNFINISHED
public class NoOfSets {

    public static void main(String[] args) {
        int sum = 16;
        int[] array = {2, 4, 14, 5, 6, 28, 10};
        for (int i = 0; i < array.length; i++) {
            int tempResult = sum - array[i];
            if (tempResult == 0) {

            } else if (tempResult < 0) {

            }
        }

    }

    int recursiveSubsetCount(int[] array, int sum) {
        if (array.length == 0) return 0;
        if (array.length == 1 && sum != array[0]) return 0;

        int count = 0;

        int tempSum = 0;
        for (int i = 0; i < array.length; i++) {
            tempSum += array[i];
        }
        if (tempSum == sum) {
            return count++;
        } else {
            //count += recursiveSubsetCount();
        }
        return 0;
    }

}
