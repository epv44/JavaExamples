package chapterTwo;

import chapterOne.Apple;

public class DisplayAppleWeight implements AppleFormatter{
    public String accept(Apple a) {
        String weight = Integer.toString(a.getWeight());
        return weight;
    }
    

}
