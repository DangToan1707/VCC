package week3.singleton;

public class DoubleCheckLock {
    private static volatile DoubleCheckLock instance;
    private DoubleCheckLock(){

    }

    public static DoubleCheckLock getInstance() {
        // thu hien code
        if(instance == null){
            instance = new DoubleCheckLock();

        }
        return instance;
    }
}
