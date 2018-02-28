package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description：TODO
 * @Author wb-zmx300072 2017/12/22 10:39
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list.subList(1,3));
    }
}
