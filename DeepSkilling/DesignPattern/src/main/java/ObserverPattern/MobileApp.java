package ObserverPattern;

public class MobileApp implements Observer {
    private  int price;
    @Override
    public void update(int price) {
        this.price = price;
        System.out.println("update from MobileApp updated price : " + price);
    }
}
