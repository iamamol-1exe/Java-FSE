package ObserverPattern;

public interface Stock {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers(int price);

}
