package chapterOne;

import java.util.ArrayList;

/**
 * @author Eric
 * Class with method to load types of apples, used this to make code cleaner and easier to use
 * throughout chapters
 */
public class LoadData {
    public static ArrayList<Apple> loadApples(){
        Apple grannysmith = new Apple("green", 3, "Grannysmith");
        Apple macintosh = new Apple("green", 4, "Macintosh");
        Apple goldenDelicious = new Apple("yellow", 2, "Golden Delicious");
        Apple redDelicious = new Apple("red", 155, "Red Delicious");
        Apple jonagold = new Apple("red-yellow", 160, "Jonagold");
        Apple cortland = new Apple("red", 130, "Cortland");
        Apple pinkLady = new Apple("red", 155, "Pink Lady");
        ArrayList<Apple> apples = new ArrayList<Apple>() {{
            add(grannysmith);
            add(macintosh);
            add(goldenDelicious);
            add(redDelicious);
            add(jonagold);
            add(cortland);
            add(pinkLady);
        }};
        return apples;
    }
    public static ArrayList<Integer> loadNumbers(){
        ArrayList<Integer> numbers = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            add(6);
            add(7);
        }};
        return numbers;
    }
}
