package chapterSix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import chapterFour.Dish;

public class Partitioning {
    
    static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH) );
    
    public static void vegetarianDishes(){
        Map<Boolean, List<Dish>> partitionedMenu = menu.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu.get(true));
    }
    
    public static void mostCaloricPartitionedByVegetarian(){
        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian, 
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), 
                                Optional::get)));
        System.out.println(mostCaloricPartitionedByVegetarian);
    }
    
    //return true if the candidate isn't divisible by any of the numbers in the stream
    public static boolean isPrime(int candidate){
        //optimize by checking the square root of the candidate, could probably use
        //memoization here
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.range(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }
    
    public static void partitionPrimes(){
        Map<Boolean, List<Integer>> partitionPrimes = 
                IntStream.rangeClosed(2,30).boxed().collect(
                        Collectors.partitioningBy(candidate -> isPrime(candidate)));
        System.out.println(partitionPrimes);
    }
}
