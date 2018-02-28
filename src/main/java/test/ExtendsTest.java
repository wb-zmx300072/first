package test;

/**
 * Created by wb-zmx300072 on 2017/11/16.
 */
public class ExtendsTest {

    static{
        System.out.println("parent static .....");
    }
    public  void syso(){
        System.out.println(this.getClass().getName());
    }
}
