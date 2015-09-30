package chapterFive;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import chapterFour.Dish;

/**
 * @author Eric
 * Chapter 5 section one code samples
 */
public class Filtering {
  //filter using a predicate, in this case vegetarian
    public static void vegetarianPredicate(List<Dish> menu){
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        vegetarianMenu.stream().forEach(System.out::println);
    }
    //filter unique elements in a stream
    public static void filterUnique(){
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
    }
    //truncate a stream
    public static void truncateStream(List<Dish> menu){   
        List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());
        dishes.stream().forEach(System.out::println);
    }
    //skip first 2
    public static void skipDish(List<Dish> menu){
        List<Dish> dishesSkip = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .collect(Collectors.toList());
        dishesSkip.stream().forEach(System.out::println);
    }
    //quiz 5.1
    public static void quizOne(List<Dish> menu){
        List<Dish> dishesQuiz = menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("Quiz Results:");
        dishesQuiz.stream().forEach(System.out::println);
    }
}
