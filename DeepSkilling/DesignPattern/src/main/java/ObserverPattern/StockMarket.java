package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock{
    List<Observer> observers;

    StockMarket(){
        observers = new ArrayList<>();
    }


    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }
    public void unregister(Observer observer) {
       observers.remove(observers);
    }



    public void notifyObservers(int price) {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }
}
