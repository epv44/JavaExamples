package chapterEight;

public class ChapterEight {

    public static void main(String[] args) {
//        Validator numericValidator = 
//                new Validator((String s) -> s.matches("[a-z]+"));
//        boolean b1 = numericValidator.validate("aaa");
//        Validator lowerCaseValidator = 
//                new Validator((String s) -> s.matches("\\d+"));
//        boolean b2 = lowerCaseValidator.validate("bbbb");
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObservers("The queen said her favourite book is Java 8 in Action");
    }

}
