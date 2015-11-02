package chapterNine;

public interface B extends A {
    default void hello(){
        System.out.println("Hello from b");
    }
}
