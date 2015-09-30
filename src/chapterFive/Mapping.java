package chapterFive;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Eric
 * Chapter 5 section 2
 */
public class Mapping {
    static List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
    //print length of each word in collection
    public static void wordLength(){
        List<Integer> wordLengths = words.stream().map(String::length).collect(Collectors.toList());
        System.out.println("Word Count: ");
        wordLengths.stream().forEach(System.out::println);
    }
    //flat map
    public static void uniqueChars(){
        List<String> uniqueCharacters = words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique Characters");
        uniqueCharacters.stream().forEach(System.out::println);
    }
    
    //quiz 5.2
    public static void quizTwo(){
        List<Integer> listNumbers = Arrays.asList(1,2,3,4,5);
        List<Integer> squares = listNumbers.stream()
                .map(n -> n*n)
                .collect(Collectors.toList());
        System.out.println("Quiz 5.2");
        squares.stream().forEach(System.out::println);
    }
    //quiz 5.3
    public static void quizThree(){
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(3,4);
        
        List<int[]> superList = list1.stream()
                .flatMap((Integer i) -> list2.stream().filter(j -> (i+j) % 3 == 0)
                        .map((Integer j) -> new int[]{i, j}))
                .collect(Collectors.toList());
        System.out.println(Arrays.deepToString(superList.toArray()));
    }
}
