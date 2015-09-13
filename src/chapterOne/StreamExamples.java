package chapterOne;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


/**
 * @author Eric
 * Examples from chapter one of Java 8 in Action: Lambdas, streams, and functional style programming
 */
public class StreamExamples {
    public static void main(String [] args){
        //get files and store hidden files in array
        URL url = null;
        try {
            url = new URL("file://C:/Users/ericsMac/Documents/workspace/Examples Java8 In Action/src/chapterOne/TestData");
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL");
            e.printStackTrace();
        }
      
       File [] hiddenFiles = new File(url.getPath()).listFiles(File::isHidden);
       for(File hiddenFile: hiddenFiles){
           System.out.println("Hidden file name is: " + hiddenFile.getName());
       }

        //methods and lambdas as first class citizens
        System.out.println("Apples Example ==============================");
        ArrayList<Apple> inventory = LoadData.loadApples();
        List<Apple> results = filterApples(inventory, Apple::isGreenApple);
        for(Apple apple: results){
            System.out.println(apple.getType());
        }
        //now written as a lambda function, helpful if method would only be used once or twice
        List<Apple> moreResults = filterApples(inventory, (Apple a) -> "red".equals(a.getColor()) );
        for(Apple apple: moreResults){
            System.out.println(apple.getType());
        }
    }   
    
    //the method is passed as the predicate parameter p
    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        //result accumulates the apples fitting the criteria
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if (p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
