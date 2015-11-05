package chapterFourteen;

import java.util.function.DoubleUnaryOperator;

public class Functions {
    public static double converter(double x, double f, double b){
        return x * f + b;
    }
    public static DoubleUnaryOperator curriedConverter(double f, double b){
        return (double x) -> x * f + b;
    }
}
