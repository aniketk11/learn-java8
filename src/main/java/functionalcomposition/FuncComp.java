package functionalcomposition;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.function.Function;
import java.util.function.Predicate;

public class FuncComp {
    public static void main(String[] args) {

//      Functional composition is a technique to combine multiple functions into a single function which uses the combined functions internally.

        System.out.println(startsWithAandEndsWithX("A hardworking person must relax"));

        Function<Integer, Integer> multiply = (value) -> value * 2;
        Function<Integer, Integer> add = (value) -> value + 3;

        Function<Integer, Integer> multiplyAddThen = multiply.andThen(add);  // andThen() - Multiply and then Add
        Function<Integer, Integer> addThenMultiply = multiply.compose(add);  // compose() - Add and then Multiply

        Integer result = addThenMultiply.apply(3);
        Integer result1 = multiplyAddThen.apply(3);
        System.out.println(result + " --- " + result1);

    }

    public static boolean startsWithAandEndsWithX(String str) {
        Predicate<String> startsWithA = val -> val.startsWith("A");
        Predicate<String> endsWithX = val -> val.endsWith("x");

        Predicate<String> startsWithAandEndsWithX = startsWithA.and(endsWithX);
//        Predicate<String> startsWithAandEndsWithX = val -> startsWithA.test(val) && endsWithX.test(val);

        return startsWithAandEndsWithX.test(str) ? true : false;
    }
}
