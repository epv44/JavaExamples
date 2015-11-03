package chapterEleven;

import org.junit.Test;

public class ChapterElevenTest {
    
    @Test
    public void findPricesRuntime() {
        System.out.println("--------Sequential Stream --------");
        BestPriceFinder bestPriceFinder = new BestPriceFinder();
        long start = System.nanoTime();
        System.out.println(bestPriceFinder.findPricesSequential("myPhone27s"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }
    
    @Test
    public void findParallelPricesRuntime(){
        System.out.println("--------Parallel Stream --------");
        BestPriceFinder bestPriceFinder = new BestPriceFinder();
        
        long start = System.nanoTime();
        System.out.println(bestPriceFinder.findPricesParallel("myPhone27s"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }
    
    @Test
    public void findAsyncPricesRuntime(){
        System.out.println("--------Async Stream --------");
        BestPriceFinder bestPriceFinder = new BestPriceFinder();
        bestPriceFinder.printPricesStream("myPhone27s");
    }
    
    @Test
    public void findPrice(){
        System.out.println("-------- Async Find Price --------");
        Shop shop = new Shop("Best Shop");
        BestPriceFinder bestPriceFinder = new BestPriceFinder();
        bestPriceFinder.findPrice(shop);
    }
    
    @Test
    public void getPrice(){
        Shop shop = new Shop("Best Buy");
        System.out.println(shop.getPrice("mine"));
    }
}
