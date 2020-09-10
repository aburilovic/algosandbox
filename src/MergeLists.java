import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MergeLists {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(5);
        list1.add(8);
        list1.add(11);
        list1.add(14);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(3);
        list2.add(5);
        list2.add(7);

        List<Integer> resultList = mergeList2(list1, list2);

        resultList.sort(Comparator.naturalOrder());
        Iterator<Integer> iter = resultList.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public static List<Integer> mergeList2(List<Integer> list1, List<Integer> list2) {
        Iterator<Integer> iter = list2.iterator();
        while(iter.hasNext()) {
            list1.add(iter.next());
        }
        return list1;
    }

    // all lists should be sorted
    public static List<Integer> mergeList(List<Integer> list1, List<Integer> list2) {
        Iterator<Integer> firstIterator = list1.iterator();
        Iterator<Integer> secondIterator = list2.iterator();
        List<Integer> resultList = new ArrayList<>();

        Integer elem1 = null;
        Integer elem2 = null;
        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            if (elem1 == null) {
                elem1 = firstIterator.next();
            }
            if (elem2 == null) {
                elem2 = secondIterator.next();
            }

            if (elem1.intValue() <= elem2.intValue()) {
                resultList.add(elem1);
                elem1 = firstIterator.next();
            } else {
                resultList.add(elem2);
                elem2 = secondIterator.next();
            }
        }

        if (elem1.intValue() <= elem2.intValue()) {
            resultList.add(elem1);
            resultList.add(elem2);
        } else {
            resultList.add(elem2);
            resultList.add(elem1);
        }

        if (firstIterator.hasNext()) {
            while (firstIterator.hasNext()) {
                resultList.add(firstIterator.next());
            }
        } else if (secondIterator.hasNext()) {
            while (secondIterator.hasNext()) {
                resultList.add(secondIterator.next());
            }
        }
        return resultList;
    }
}
