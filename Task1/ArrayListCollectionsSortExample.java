import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArrayListCollectionsSortExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(13);
        numbers.add(7);
        numbers.add(18);
        numbers.add(5);
        numbers.add(2);

        Collections.sort(numbers);
        System.out.println("Before : " + numbers);

        System.out.println("After : "+numbers);
    }
}
 22
         ArrayList/src/ArrayListIteratorRemoveExample.java
@@ -0,0 +1,22 @@
        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.List;

public class ArrayListIteratorRemoveExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(13);
        numbers.add(18);
        numbers.add(25);
        numbers.add(40);

        Iterator<Integer> numbersIterator = numbers.iterator();
        while (numbersIterator.hasNext()) {
            Integer num = numbersIterator.next();
            if(num % 2 !=0) {
                numbersIterator.remove();
            }
        }
        System.out.println(numbers);
    }
}