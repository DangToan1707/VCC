package week3.singleton;

public class EageInitialization {
    private  static final EageInitialization instance = new EageInitialization();
    // ham su dung rieng tranh cac ung dung client su dung ham tao
    private  EageInitialization(){

    }
    public static EageInitialization getInstance(){
        return instance;
    }
}

