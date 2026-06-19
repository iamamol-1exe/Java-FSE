package singleton;

public class Main {

    public static void main(String[] args) {

        Logger logger = Logger.getObj();
        Logger logger1 = Logger.getObj();
        System.out.println(logger);
        System.out.println(logger1);


        // singleton patterns using enum
//        Abc abc = Abc.INSTANCE;
//        abc.i = 34;
//
//        abc.show();
//
//        Abc abc1 = Abc.INSTANCE;
//        abc1.i= 343;
//        abc.show();

    }
}



enum Abc {
    INSTANCE;
    int i;

       public  void  show (){
           System.out.println(i);
       }
}
