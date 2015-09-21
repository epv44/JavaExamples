package chapterOne;

/**
 * @author Eric
 * Apple object used in chapter one, contains a color, weight, and type (name of the apple)
 *
 */
public class Apple {
    String color;
    int weight;
    String type;
    
    public Apple(String initialColor, int initialWeight, String type){
        color = initialColor;
        weight = initialWeight;
        this.type = type;
    }
    public Apple(int iWeight){
        weight = iWeight;
    }

    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }
    
    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight() > 150;
    }
    
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
}
