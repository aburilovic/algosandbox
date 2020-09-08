import java.util.Iterator;
import java.util.LinkedList;

public class ListAdder {

    public static void main(String[] args) {
        final LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(8);
        l1.add(2);
        l1.add(5);

        final LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(4);
        l2.add(9);
        l2.add(2);

        final LinkedList<Integer> resultList = addTwoLists(l1, l2);
        final Iterator<Integer> iterator = resultList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }

    private static LinkedList<Integer> addTwoLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        final LinkedList<Integer> resultList = new LinkedList<>();
        final Iterator<Integer> iterator1 = list1.iterator();
        final Iterator<Integer> iterator2 = list2.iterator();
        int carry = 0;
        while (iterator1.hasNext() || iterator2.hasNext()) {
            int num1 = iterator1.hasNext() ? iterator1.next() : 0;
            int num2 = iterator2.hasNext() ? iterator2.next() : 0;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            resultList.add(sum % 10);
        }
        return resultList;
    }
}
