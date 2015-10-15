package chapterFive;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreams {
    public static void findEvenNumbers(){
        //rangeClosed is inclusive, range is exclusive and would return 49 as the final answer
        IntStream evenNumbers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());
    }
    //calculate pythagorean triples
    public static void pythagoreanTriples(){
        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                IntStream.rangeClosed(a, 100)
                .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                .mapToObj(b ->
                new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
                        );
        pythagoreanTriples.limit(5)
        .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

    }
    public static void pythagoreanTripleRefactor(){
        Stream<double[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                IntStream.rangeClosed(a, 100)
                .mapToObj(b -> 
                new double[]{a, b, Math.sqrt(a*a +b*b)})
                        .filter(t -> t[2] % 1 == 0));
        System.out.println("Improved Runtime");
        pythagoreanTriples.limit(5)
        .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }
}
