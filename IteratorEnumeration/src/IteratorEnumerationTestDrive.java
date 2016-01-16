import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

public class IteratorEnumerationTestDrive {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);

        Iterator<Integer> iterator = nums.iterator();

        Enumeration iteratorEnumeration = new IteratorEnumeration(iterator);
        while (iteratorEnumeration.hasMoreElements()) {
            System.out.print(iteratorEnumeration.nextElement() + " ");
        }
        System.out.println("\n");
    }
}
