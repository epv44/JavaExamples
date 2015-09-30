package chapterFive;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import chapterFour.Dish;

public class Reducing {
    public static void numberManipulation(){
        List<Integer> numbers = Arrays.asList(4,5,3,9);
        //Integer::sum == (a, b) -> a + b
        //Optional<Integer> sum is the overload varient
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println("Max: " + max + " , " + "min: " + min);
    }
    //classic map reduce example, of course could use built in method count()
    public static void quizFour(List<Dish> menu){
        int numberDishes = menu.stream().map(d -> 1).reduce(0, (t, d) -> t + d);
        System.out.println("Quiz 4: " + numberDishes);
    }
}
