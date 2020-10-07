package week3.singleton;

public class BlockInitialization {
    private static final BlockInitialization instance;
    private BlockInitialization(){

    }
    //khoi tao kho static de xu ly ngoai le
    static {
        try {
            instance = new BlockInitialization();
        }catch (Exception e){
            throw new RuntimeException(" gap loi khi khoi tao doi tuong");
        }
    }

    public static BlockInitialization getInstance(){
        return instance;
    }

}