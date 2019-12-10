package functionalinterface;

import java.util.function.*;

public class FuncInterface {

    public static void main(String[] args) {

        SimpleFunctionalInterface simpleLambda = () -> System.out.println("Executing...");
        simpleLambda.execute();

//      Funtion is a built-in Functional Interface in Java that takes T as parameter and returns R.
        Function<Integer, Integer> anon = new Function<Integer, Integer>() {
            public Integer apply(Integer aLong) {
                return aLong + 3;
            }
        };
        System.out.println(anon.apply(3));

//      Lambda implementation of above built-in anon inner class statement
        Function<Integer, Integer> funcLambda = (a) -> a + 3;

        System.out.println("Function: " + funcLambda.apply(3));

//      Lambda implementation of above built-in anon inner class statement
        BiFunction<Integer, Integer, Integer> biFuncLambda = (a, b) -> a + b + 3;

        System.out.println("BiFunction: " + biFuncLambda.apply(3, 4));

//      Takes single parameter and expects same type to be returned.
        UnaryOperator<String> unaryOperator = (person) -> {
            return "New Name: " + person;
        };
        System.out.println("Unary: " + unaryOperator.apply("Aniket"));

//      Takes 2 parameters and expects same type to be returned.
        BinaryOperator<Integer> binaryOperator = (a, b) -> {
            return a + b;
        };
        System.out.println("Binary: " + String.valueOf(binaryOperator.apply(2, 2)));

        /*
         * The Java Supplier interface is a functional interface
         * that represents an function that supplies a value of some sorts.
         * The Supplier interface can also be thought of as a factory interface.
         */
        Supplier<Integer> supplier = () -> new Integer((int) (Math.random() * 1000D));
        System.out.println(supplier.get());

        /*
         * The Java Consumer interface is a functional interface that represents an function
         * that consumes a value without returning any value. A Java Consumer implementation
         * could be printing out a value, or writing it to a file, or over the network etc.
         */
        Consumer<Integer> consumer = (value) -> System.out.println(value);
        consumer.accept(10);

    }
}
