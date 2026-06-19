package singleton;

public class ThreaTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                Logger logger = Logger.getObj();
                System.out.println(logger);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Logger logger2 = Logger.getObj();
                System.out.println(logger2);
            }
        });



        t1.start();
//        Thread.sleep(100); this can also handle but time taking
        t2.start();

    }
}
