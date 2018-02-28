package test.beancopy;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) throws Exception {
        testList();

    }

    private static void testBean() {
        A a = new A();
        a.setStr1("str1");
        a.setStr2("str2");
        B b = new B();
        b.setStr1("str3");
        b.setStr2("str4");
        BeanUtils.copyProperties(a, b);
        print(a, b);
        a.setStr1("hahah");
        print(a, b);
    }


    private static void testList() throws Exception {
        int listSize = 2;
        List<A> aList = new ArrayList<A>();
        List<B> bList = new ArrayList<B>();
        for (int i = 0; i < listSize; i++) {
            A a = new A();
            a.setStr1("str1 ..."+i);
            aList.add(a);
        }
        BeanCopyUtils.copyBean(aList, bList);
        System.out.println("aList.size..." + aList.size());
        System.out.println("bList.size..." + bList.size());
        for (int i = 0; i < listSize; i++) {
            A a = aList.get(i);
//           System.out.println(" str1 in a "+a.getStr1()+" ");
          /* B b =  bList.get(i);
           System.out.println(" str1 in a "+a.getStr1()+" , str1 in b "+ b.getStr1() + a +" "+b+ " equal?" + (a.equals(b)));*/
        }
    }

    private static void print(A a, B b) {
        System.out.println(a.getStr1());
        System.out.println(a.getStr2());
        System.out.println(b.getStr1());
        System.out.println(b.getStr2());
        System.out.println("===============");

    }
}
