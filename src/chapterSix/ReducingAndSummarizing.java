package chapterSix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import chapterFour.Dish;

public class ReducingAndSummarizing {
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
    
    public static void maximumDishes(){
        //Create comparator comparing dishes based on calories
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
        System.out.println(mostCalorieDish);
    }
    
    public static void totalCalories(){
        int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("Total Calories: " + totalCalories);
    }
    
    public static void averageCalories(){
        double avgCalories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println("Average Calories: " + avgCalories);
    }
    
    public static void menuStatistics(){
        IntSummaryStatistics menuStats =
                menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(menuStats);
    }
    
    public static void joiningString(){
        String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println(shortMenu);
        String[] s = {"the", "dog", "jumped", "over", "me"};
        String testing = Arrays.stream(s).collect(Collectors.joining(" "));
        System.out.println(testing);
    }
}
