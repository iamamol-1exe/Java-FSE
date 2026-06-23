package ObserverPattern;

public class Main {
    public static void main(String[] args) {
        Stock stockMarket = new StockMarket();
        Observer observer = new MobileApp();
        stockMarket.register(observer);
        Observer observer1 = new WebApp();
        stockMarket.register(observer1);
        Observer observer2 = new WebApp();
        stockMarket.register(observer2);
        Observer observer3 = new WebApp();
        stockMarket.register(observer3);

        stockMarket.notifyObservers(435);
    }
}
