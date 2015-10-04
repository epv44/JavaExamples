package chapterFive;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.List;

public class PuttingItTogether {
    static Trader raoul = new Trader("Raoul", "Cambridge");
    static Trader mario = new Trader("Mario", "Milan");
    static Trader alan = new Trader("Alan", "Cambridge");
    static Trader brian = new Trader("Brian", "Cambridge");
    
    static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
            );
    
    
    //Find all transactions in the year 2011 and sort them by value (small to high).
    public static void transactions2011(){
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .map(t -> t.getTrader())
                .forEach(System.out::println);
    }
    //What are all the unique cities where the traders work?
    public static void uniqueCities(){
        transactions.stream()
            .map(t -> t.getTrader().getCity())
            .distinct()
            .forEach(System.out::println);
    }
    //Find all traders from Cambridge and sort them by name.
    public static void fromCambridge(){
        transactions.stream()
            .map(t -> t.getTrader())
            .filter(t -> t.getCity().equals("Cambridge"))
            .distinct()
            .sorted(comparing(Trader::getName))
            .forEach(System.out::println);
    }
    //Return a string of all traders’ names sorted alphabetically.
    public static void allNames(){
        transactions.stream()
            .map(t -> t.getTrader())
            .distinct()
            .sorted(comparing(Trader::getName))
            .forEach(System.out::println);
    }
    //Are any traders based in Milan?
    public static void basedInMilan(){
        transactions.stream()
            .map(t -> t.getTrader())
            .filter(t -> t.getCity().equals("Milan"))
            .findAny()
            .ifPresent(print -> System.out.println("Yes"));
    }    
    //Print all transactions’ values from the traders living in Cambridge.
    public static void basedInCambridge(){
        transactions.stream()
            .filter(t -> t.getTrader().getCity().equals("Milan"))
            .map(t -> t.getValue())
            .forEach(System.out::println);
    }
    //What’s the highest value of all the transactions?
    public static void highestValue(){
        transactions.stream()
            .max(comparing(Transaction::getValue))
            .ifPresent(System.out::println);
    }
    //Find the transaction with the smallest value.
    public static void smallestValue(){
        transactions.stream()
            .min(comparing(Transaction::getValue))
            .ifPresent(System.out::println);
    }
}
