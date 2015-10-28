package chapterEight;

public class Guardian implements Observer{
    public void notify(String tweet){
        if(tweet != null && tweet.contains("queen")){
            System.out.println("Yet another news in London... " + tweet);
        }
    }
}
