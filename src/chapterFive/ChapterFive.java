package chapterFive;

import java.util.Arrays;
import java.util.List;

import chapterFour.Dish;

public class ChapterFive {
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

    public static void main(String args[]){
        //Section 5.1
        /*
        Filtering.vegetarianPredicate(menu);
        Filtering.filterUnique();
        Filtering.truncateStream(menu);
        Filtering.skipDish(menu);
        Filtering.quizOne(menu);
         */
        //Section 5.2
        /*
        Mapping.wordLength();
        Mapping.uniqueChars();
        Mapping.quizTwo();
        Mapping.quizThree();
         */
        //Section 5.3
        /*
        FindingAndMatching.isDishVegetarian(menu);
        FindingAndMatching.isMenuLowCal(menu);
        FindingAndMatching.isVegetarian(menu);
        FindingAndMatching.findFirstElement();
         */
        //section 5.4
        /*
        Reducing.numberManipulation();
        Reducing.quizFour(menu);
         */
        //section 5.5
        /*
        PuttingItTogether.transactions2011();
        PuttingItTogether.uniqueCities();
        PuttingItTogether.fromCambridge();
        PuttingItTogether.allNames();
        PuttingItTogether.basedInMilan();
        PuttingItTogether.basedInCambridge();
        PuttingItTogether.highestValue();
        PuttingItTogether.smallestValue();
        */
        //section 5.6
        /*
        NumericStreams.findEvenNumbers();
        NumericStreams.pythagoreanTripleRefactor();
        */
        //section 5.7
        //StreamsFromValues.streamFromFile();
        StreamsFromValues.fibonacci();
    }
}
