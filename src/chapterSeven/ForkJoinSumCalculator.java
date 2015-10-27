package chapterSeven;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoinSumCalculator extends java.util.concurrent.RecursiveTask<Long>{
    //array of numbers to be summed
    private final long[] numbers;
    //initial and final positions of the portion of teh array processed by this subtask
    private final int start;
    private final int end;
    //The size of the array under which the task is no longer split into subtasks
    public static final long THRESHOLD = 10_000;
    //public constructor used to create the main task
    public ForkJoinSumCalculator(long[] numbers){
        this(numbers, 0, numbers.length);
    }
    //private constructor used to recursively create subtasks of the main task
    private ForkJoinSumCalculator(long[] numbers, int start, int end){
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }
    
    @Override
    protected Long compute(){
        //the size of the portion of the array summed by this task
        int length = end - start;
        //if the size is <= the threshold compute the result sequentially
        if(length <= THRESHOLD){
            return computeSequentially();
        }
        //create a subtask to sum the first half of the array
        ForkJoinSumCalculator leftTask = 
                new ForkJoinSumCalculator(numbers, start, start + length/2);
        //asynchronously execute the newly created subtask using another thread
        leftTask.fork();
        //create a subtask to sum the second half of the array
        ForkJoinSumCalculator rightTask =
                new ForkJoinSumCalculator(numbers, start + length/2, end);
        //execute subtasks, allowing further recursive splits.
        Long rightResult = rightTask.compute();
        Long leftResult = (Long) leftTask.join();
        
        //
        return leftResult + rightResult;
    }
    
    //calculate the result of a subtask when it is no longer divisible
    private long computeSequentially(){
        long sum = 0;
        for(int i = start; i < end; i++){
            sum += numbers[i];
        }
        return sum;
    }
    
    public static long forkJoinSum(long n){
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }
    
}
