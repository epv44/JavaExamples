package chapterThree;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import static java.util.Comparator.comparing;

import chapterOne.Apple;

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
        
        //3.6.2 Constructor References
        List<Integer> weights = Arrays.asList(7,3,4,10);
        List<Apple> apples = mapL(weights, Apple::new);
        //sort apples by weight
        apples.sort(comparing(Apple::getWeight));
        forEach(apples, (Apple a) -> System.out.println(a.getWeight()));
        
        //3.7 Tranformation piplines
        
        //add header then check spelling then add footer
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline = 
                addHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);
        System.out.println(transformationPipeline.apply("Bruce Banner aka huk"));        
        //add header then add footer
        Function<String, String> transformationPipelineWithoutSpelling = 
                addHeader.andThen(Letter::addFooter);
        System.out.println(transformationPipelineWithoutSpelling.apply("Bruce Banner aka huk"));
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
    
    //map function for apples 3.6.2
    public static List<Apple> mapL(List<Integer> list, Function<Integer, Apple> f){
        List<Apple> result = new ArrayList<>();
        for(Integer e: list){
            result.add(f.apply(e));
        }
        return result;
    }
}
