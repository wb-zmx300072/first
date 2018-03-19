package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description：TODO
 * @Author wb-zmx300072 2018/1/4 17:02
 */
public class TT {

    private  static String globalStr = "";


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.remove(1);
        System.out.println(list.size());
    }



    public static void transfer(){
        String e = "a";
        globalStr = e;
        e = "b";
    }


}
