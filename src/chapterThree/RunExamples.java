package chapterThree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Eric
 * Examples form chapter three
 */
public class RunExamples{

    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("Hello World 1");
        Runnable r2 = new Runnable(){
            public void run(){
                System.out.println("Hello World 2");
            }
        };
        process(() -> System.out.println("This is awesome!!"));
        //multi line lambda 
        process(() -> { int i = 2+2; System.out.println(i); });
        process(r1);
        process(r2);
        //Behavior Parameterization and Execute Around Pattern
        try {
            String result = processFile((BufferedReader br) -> br.readLine() + ", " + br.readLine());
            System.out.println(result);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //generic consumer method example
        forEach(Arrays.asList(1,2,3,4,5,6), (Integer i) -> System.out.println(i));
        //generic function method example output: [7,2,6]
        System.out.println(map(Arrays.asList("lambdas", "in", "action"), (String s) -> s.length()));
    }

    public static void process(Runnable r){
        r.run();
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
            return p.process(br);
        }
    }
    
    //generic consumer method 
    public static <T> void forEach(List<T> list, Consumer<T> c){
        for(T i: list){
            c.accept(i);
        }
    }
    
    //generic function method
    public static <T, R> List<R> map(List<T> list, Function<T, R> f){
        List<R> result = new ArrayList<>();
        for(T s: list){
            result.add(f.apply(s));
        }
        return result;
    }
}
