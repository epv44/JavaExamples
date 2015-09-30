package chapterFive;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import chapterFour.Dish;

public class FindingAndMatching {
    //find if dish is vegetarian in menu
    public static void isVegetarian(List<Dish> menu){
        if(menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is somewhat vegetarian friendly!!");
        }
    }
    //find if all menu items are under 1000 calories
    public static void isMenuLowCal(List<Dish> menu){
        if(menu.stream().allMatch(d -> d.getCalories() < 1000)){
            System.out.println("Low calorie menu, no gains for you :(");
        }
    }
    
    //noneMatch not depicted
    //another way to find if dish is vegetarian using the findAny() method (short-circuit eval)
    public static void isDishVegetarian(List<Dish> menu){
        menu.stream().filter(Dish::isVegetarian).
        findAny().ifPresent(d -> System.out.println(d.getName()));
    }
    
    //findFirstElement
    public static void findFirstElement(){
        List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);
        Optional<Integer> firstSquareDivisibleByThree = 
                someNumbers.stream()
                .map(x -> x*x)
                .filter(x -> x % 3 == 0)
                .findFirst(); //9
        firstSquareDivisibleByThree.ifPresent(i -> System.out.println(i.toString()));
    }
}
