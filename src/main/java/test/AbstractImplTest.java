package test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wb-zmx300072 on 2017/11/13.
 */
public class AbstractImplTest extends AbstractTest {
    protected  String getStr1(){
        return "";
    }

    public static void main(String[] args) {
/*        AbstractImplTest abstractImplTest = new AbstractImplTest();

        System.out.println("args = [" +  abstractImplTest.getStr1() + "]");
        System.out.println("args = [" +  abstractImplTest.getStr() + "]");*/
        Set<Integer> intSet = new HashSet<Integer>();
        for (int i = 0;i<17;i++){
            intSet.add(i);
        }
    }
}
