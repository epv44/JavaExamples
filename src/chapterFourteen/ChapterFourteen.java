package chapterFourteen;

import java.util.function.DoubleUnaryOperator;

public class ChapterFourteen {
    public static void main(String[] args){
        DoubleUnaryOperator convertCtoF = Functions.curriedConverter(9.0/5, 32.0);
        DoubleUnaryOperator convertUSDtoGBP = Functions.curriedConverter(0.6, 0.0);
        DoubleUnaryOperator convetKmtoMi = Functions.curriedConverter(.6214, 0.0);
        
        System.out.println("GBP: " + convertUSDtoGBP.applyAsDouble(1000));       
    }
}
