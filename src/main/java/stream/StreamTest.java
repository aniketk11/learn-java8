package stream;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamTest {

    public static void main(String[] args) {

       List<String> stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a mockingbird");
        stringList.add("Gone with the wind");

//      flatMap implementation
        stringList.stream()
                .map((value) -> value.split(" ")) // Non-Terminal operation
                .flatMap(Arrays::stream)
                .forEach(System.out::println);          // Terminal operation

        stringList.stream()
                .flatMap((value) -> {
                    String[] split = value.split(" ");
                    return Arrays.stream(split);
                })
                .peek(System.out::println)              // Non-Terminal operation (nothing will be printed)
                .count();                                // Now since terminal operatoin is called, peek will print.

        /*
        * Terminal operation .
        * If the Predicate returns true for any of the elements, the anyMatch() method returns true.
        * (allMatch() method will return true only if the Predicate returns true for all elements in the Stream)
        * (noneMatch() method will return true if no elements are matched by the Predicate)
        */
        Boolean isMatching = stringList.stream()
                  .anyMatch((value) -> value.startsWith("o"));

        System.out.println(isMatching);     // Returns true because of the word "over".

        Optional<String> opt = stringList.stream().findFirst();
        System.out.println(opt);

    }

}
