package week3.singleton;

import java.util.Scanner;

public class LazyInitialization {
    private static LazyInitialization instance;
    private LazyInitialization(){

    }
    // khi nao ham getInstance duoc goi thi moi khoi tao doi tuong
    public static LazyInitialization getInstance(){
        if(instance == null){
            instance = new LazyInitialization();
        }
        return instance;
    }
}
