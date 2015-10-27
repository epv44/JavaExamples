package chapterSeven;

public class WordCounter {
    private final int counter;
    private final boolean lastSpace;
    public WordCounter(int counter, boolean lastSpace){
        this.counter = counter;
        this.lastSpace = lastSpace;
    }
    
    //traverses the Characters one by one as done by the iterative algorithm
    public WordCounter accumulate(Character c){
        //increases the word counter when the last character is a space and the 
        //currently traversed one isn't
        if(Character.isWhitespace(c)){
            return lastSpace ? 
                    this :
                        new WordCounter(counter, true);
        }else{
            return lastSpace ?
                    new WordCounter(counter + 1, false) :
            this;
        }
    }
    
    //combine two wordCounters by summing their counters
    public WordCounter combine(WordCounter wordCounter){
        return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
    }
    
    public int getCounter(){
        return counter;
    }
}
