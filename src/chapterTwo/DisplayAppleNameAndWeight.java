package chapterTwo;

import chapterOne.Apple;

public class DisplayAppleNameAndWeight implements AppleFormatter{
    public String accept(Apple a) {
        String output = a.getType() + " " + Integer.toString(a.getWeight());
        return output;
    }

}
