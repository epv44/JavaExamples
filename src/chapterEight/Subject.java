package chapterEight;

public interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String tweet);
}
