package chapterTwo;
import java.util.ArrayList;
import java.util.List;

import chapterOne.Apple;
import chapterOne.LoadData;

public class ApplesUpdate {
    public static void main(String args[]){
        ArrayList<Apple> inventory = LoadData.loadApples();
        List<Apple> redAndHeavyApples = filterApples(inventory, new AppleRedAndHeavyPredicate());
        for(Apple apple: redAndHeavyApples){
            System.out.println(apple.getType());
        }
    }
    
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
