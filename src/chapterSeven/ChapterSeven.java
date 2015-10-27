package chapterSeven;

public class ChapterSeven {

    public static void main(String[] args) {
//        System.out.println("Sequential sum done in: " + 
//                ParallelStreams.measureSumPerf(ParallelStreams::sequentialSum, 10_000_000) + "msecs");
//        System.out.println("Iterative sum done in: " +
//                ParallelStreams.measureSumPerf(ParallelStreams::iterativeSum,  10_000_000) + "msecs");
//        System.out.println("Parallel sum done in: " +
//                ParallelStreams.measureSumPerf(ParallelStreams::parallelSum, 10_000_000) + "msecs");
        System.out.println("ForkJoin sum done in: " + ParallelStreams.measureSumPerf(
                ForkJoinSumCalculator::forkJoinSum, 10_000_000) + " msecs" );

    }

}
