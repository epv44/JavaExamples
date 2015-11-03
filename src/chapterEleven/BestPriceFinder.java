package chapterEleven;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BestPriceFinder {
    List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"));
    
    private final Executor executor =
            //select a thread pool with the number of threads equal to the minimum between
            //100 and the number of shops
            Executors.newFixedThreadPool(Math.min(shops.size(), 100),
                    new ThreadFactory(){
                public Thread newThread(Runnable r) {
                    Thread t = new Thread(r);
                    //use daemon thread to prevent the termination of the program
                    t.setDaemon(true);
                    return t;
                }
            });
    
    public List<String> findPricesSequential(String product ){
        return shops.stream()
                .map(shop -> shop.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }
    
    public List<String> findPricesParallel(String product){
        return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), 
                        shop.getPriceOld(product))).collect(Collectors.toList());
    }
    
    public Stream<CompletableFuture<String>> findPricesStream(String product) {
        return shops.stream()
                 .map(shop -> CompletableFuture.supplyAsync(
                                       () -> shop.getPrice(product), executor))
                 .map(future -> future.thenApply(Quote::parse))
                 .map(future -> future.thenCompose(quote ->
                          CompletableFuture.supplyAsync(
                              () -> Discount.applyDiscount(quote), executor)));
    }
    
    public void printPricesStream(String product){
        long start = System.nanoTime();
        //return is a CompletableFuture<Void>
        @SuppressWarnings("rawtypes")
        CompletableFuture[] futures = findPricesStream(product)
                .map(f -> f.thenAccept(s -> System.out.println(s + " (done in " + ((System.nanoTime() - start) / 1_000_000 + " msecs)"))))
                .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(futures).join();
        System.out.println("All shops have now responded in " + ((System.nanoTime() - start) / 1_000_000) + " msecs");
    }
    
    public void findPrice(Shop shop){
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync2("my favorite product");
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after " + invocationTime + " msecs"); 

        //doSomethingElse();
        try{
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = (System.nanoTime() - start)/ 1_000_000;
        System.out.println("Price returned after " + Long.toString(retrievalTime) + " msecs");
    }
}
