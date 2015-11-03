package chapterEleven;

public class Discount {
    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);
        
        private final int percentage;
        
        Code(int percentage){
            this.percentage = percentage;
        }

        public int getPercentage() {
            return percentage;
        }
    }
    //apply discount code to the original price
    public static String applyDiscount(Quote quote){
        return quote.getShopName() + " price is " + Discount.apply(quote.getPrice(), 
                quote.getDiscountCode());
    }
    private static double apply(double price, Code code){
        //simulate delay in the Discount service response
        Shop.delay();
        return price * (100 - code.percentage)/100;
    }
}
