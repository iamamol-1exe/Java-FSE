package singleton;

public class Logger {

    private static Logger logger = null;

    private Logger(){
        System.out.println("Instance Created");
    }

    public static  Logger getObj(){ // synchronized can cause performance bottleneck
        if(logger == null){
            logger = new Logger();
            return logger;
        }

        return logger;
    }
//
//    public static  Logger getObj(){     // double-checking pattern
//        if(logger == null){
//            synchronized (Logger.class) {
//                if(logger == null) logger = new Logger();
//            }
//            return logger;
//        }
//
//        return logger;
//    }

}
