package chapterEleven;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;


public class Shop {
    private String name;
    private static final Random random = new Random();
    
    public Shop(String name) {
        this.setName(name);
    }
    public double getPriceOld(String product){
        return calculatePrice(product);
    }
    public static void delay(){
        int delay = 500 + random.nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private double calculatePrice(String product){
        Random random = new Random();
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread( () -> { 
                try{ 
                    double price = calculatePrice(product);
                    futurePrice.complete(price);
                }catch(Exception ex){
                    futurePrice.completeExceptionally(ex);
                }
        }).start();
        return futurePrice;
    }
    public Future<Double> getPriceAsync2(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }
    
    public String getPrice(String product){
        Random random = new Random();
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[
            random.nextInt(Discount.Code.values().length)];
        
        return String.format("%s:%.2f:%s", name, price, code);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
