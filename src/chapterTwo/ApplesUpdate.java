package chapterTwo;
import java.util.ArrayList;
import java.util.List;

import chapterOne.Apple;
import chapterOne.LoadData;

/**
 * @author Eric
 * Chapter 2 of Java 8 in action.  Added in lambda expressions and quiz 1 answer
 */
public class ApplesUpdate {
    public static void main(String args[]){
        ArrayList<Apple> inventory = LoadData.loadApples();
        ArrayList<Integer> numbers = LoadData.loadNumbers();
        //filter all red apples that also have a certain weight
        List<Apple> redAndHeavyApples = filterApples(inventory, new AppleRedAndHeavyPredicate());
        //Use of an anonymous class as the predicate, instead of having to create seperate classes each time
        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
           public boolean test(Apple a){ 
               return "red".equals(a.getColor());
           }
        });
        //Now using lambda expression
        List<Apple> greenApples = filterApples(inventory, (Apple apple) -> "green".equals(apple.getColor()));
        prettyPrintApple(redAndHeavyApples, new DisplayAppleNameAndWeight());
        prettyPrintApple(redApples, new DisplayAppleNameAndWeight());
        prettyPrintApple(greenApples, new DisplayAppleNameAndWeight());
        List<Apple> redAppless = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);
        System.out.println("Filter anything!!!");
        prettyPrintApple(redAppless, new DisplayAppleNameAndWeight());
        for(Integer i: evenNumbers){
            System.out.println(i);
        }
        
    }
    //filter apples specifically
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
    //filter anything boolean
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e: list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }
    //print formatter for quiz 2.1s
    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter p){
        for(Apple apple: inventory){
            String output = p.accept(apple);
            System.out.println(output);
        }
    }
}
