package test;

/**
 * Created by wb-zmx300072 on 2017/11/16.
 */
public class ExtendsTestC extends  ExtendsTest {

    static{
        System.out.println("child static .....");
    }
    public  void syso(){
        System.out.println(this.getClass().getName());
    }

    public static void main(String[] args) {
        ExtendsTest impl = new ExtendsTestC();
        impl.syso();
    }

}
