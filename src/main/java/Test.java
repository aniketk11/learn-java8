
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//        numbers.forEach((value) -> System.out.println(value));

        numbers.stream().map(e -> e % 2 ==0);


        Function<Integer, Integer> multiply = (value) -> value * 2;
        Function<Integer, Integer> add      = (value) -> value + 3;

        Function<Integer, Integer> addThenMultiply = multiply.andThen(add);

        Integer result1 = addThenMultiply.apply(3);
        System.out.println(result1);

        Predicate<String> startsWithA = (text) -> text.startsWith("A");
        Predicate<String> endsWithX   = (text) -> text.endsWith("x");

        Predicate<String> startsWithAAndEndsWithX =
                (text) -> startsWithA.test(text) && endsWithX.test(text);

    }



}
