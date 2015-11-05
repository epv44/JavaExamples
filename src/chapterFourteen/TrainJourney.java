package chapterFourteen;

public class TrainJourney {
    public int price;
    public TrainJourney onward;
    public TrainJourney(int p, TrainJourney t){
        price = p;
        onward = t;
    }
    
    //potential side effects
    public static TrainJourney link(TrainJourney a, TrainJourney b){
        if(a==null)
            return b;
        TrainJourney t = a;
        while(t.onward != null){
            t = t.onward;
        }
        t.onward = b;
        return a;
    }
    
    public static TrainJourney append(TrainJourney a, TrainJourney b){
        //if(a == null) return b; else return new TrainJourney(a.price, append(a.onward, b))
        return a == null ? b : new TrainJourney(a.price, append(a.onward, b));
    }
}
