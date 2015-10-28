package chapterEight;

//not necessary with lambda expressions
public class IsNumeric implements ValidationStrategy{
    public boolean execute(String s){
        return s.matches("\\d+");
    }
}
