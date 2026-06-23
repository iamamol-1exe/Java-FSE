package ObserverPattern;

public class WebApp implements Observer {
    private  int price;
    @Override
    public void update(int price) {
        this.price = price;
        System.out.println("update from WebApp updated price : " + price);
    }
}
