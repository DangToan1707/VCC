package week3.singleton;

import javax.swing.*;

public class TheadSafe {
    private static volatile TheadSafe instance;
    private TheadSafe(){

    }
    // dam bao tai mot thoi diem chi co duy nhat mot luong truy cap ham getInstance va dam bao co duy nhat mot the hien cua class
    public static synchronized TheadSafe getInstance(){
        if(instance == null){
            instance = new TheadSafe();
        }
        return instance;
    }

}
