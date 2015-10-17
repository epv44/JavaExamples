package chapterSix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import static java.util.stream.Collector.Characteristics.*;

public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {
    
    //Creates the collection operation starting point
    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    //Accumulates the traversed item, modifying the accumulator in place
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }
    
    //Modifies the first accumulator, combining it with the content of the second one
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> { 
            list1.addAll(list2);  
            return list1; //returns modified first accumulator
        };
    }
    //Identity function
    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<java.util.stream.Collector.Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, CONCURRENT));
    }

}
