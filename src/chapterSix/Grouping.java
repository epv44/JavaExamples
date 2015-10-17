package chapterSix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import chapterFour.Dish;

public class Grouping {

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

    public enum CaloricLevel { DIET, NORMAL, FAT }

    public static void dishType(){
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(dishesByType);
    }

    public static void caloricLevel(){
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                Collectors.groupingBy(dish -> {
                    if (dish.getCalories() <= 400)
                        return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700)
                        return CaloricLevel.NORMAL;
                    else
                        return CaloricLevel.FAT;
                } ));
        System.out.println(dishesByCaloricLevel);
    }

    public static void caloricLevelAndType(){
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        Collectors.groupingBy(Dish::getType, 
                                Collectors.groupingBy(dish -> {
                                    if (((Dish) dish).getCalories() <= 400)
                                        return CaloricLevel.DIET;
                                    else if (((Dish) dish).getCalories() <= 700)
                                        return CaloricLevel.NORMAL;
                                    else
                                        return CaloricLevel.FAT;
                                } )
                                )
                        );
        System.out.println(dishesByTypeCaloricLevel);
    }
    
    public static void typeCounts(){
        Map<Dish.Type, Long> typesCount = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(typesCount);
    }
    
    public static void caloriesByType(){
        Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, 
                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(mostCaloricByType);
    }
    
    public static void mostCaloricByType(){
        Map<Dish.Type, Dish> mostCaloricByType = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                                Optional::get)));
        System.out.println(mostCaloricByType);
    }
    
    public static void totalCaloriesByType(){
        Map<Dish.Type, Integer> totalCaloriesByType = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.summingInt(Dish::getCalories)));
        System.out.println(totalCaloriesByType);
    }
    
    public static void caloricLevelsByType(){
        Map<Dish.Type, HashSet<CaloricLevel>> caloricLevelsByType =
                menu.stream().collect(
                   Collectors.groupingBy(Dish::getType, Collectors.mapping(
                    dish -> { if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                          else return CaloricLevel.FAT; },
                          //or Collectors.toSet(), this won't guarantee type of set
                    Collectors.toCollection(HashSet::new) )));
        System.out.println(caloricLevelsByType);
    }
}
