package chapterFive;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsFromValues {
    //generate a stream of words, remove duplicates, count words, then handle IOException
    public static void streamFromFile(){
        long uniqueWords = 0;
        try(Stream<String> lines = 
                Files.lines(Paths.get("Data.txt"), Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            System.out.println(uniqueWords);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void iterate(){
        Stream.iterate(0, n -> n+2).limit(10).forEach(System.out::println);
    }
    //quiz 5.4, Fibonacci tuples
    public static void fibonacci(){
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
        .limit(20)
        .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
    }
    public static void generateRandom(){
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
    }
    public static void mutableFib(){
        IntSupplier fib = new IntSupplier(){
            private int previous = 0;
            private int current = 1;
            public int getAsInt(){
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        //IntStream avoids boxing operations
        IntStream.generate(fib).limit(10).forEach(System.out::println);
    }
}
