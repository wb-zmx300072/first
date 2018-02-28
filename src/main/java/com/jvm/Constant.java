package com.jvm;

/**
 * @Description：TODO
 * @Author wb-zmx300072 2018/1/23 15:46
 */
public class Constant {

    public static void main(String[] args) {
        String hello = "Hello", lo = "lo";

        System.out.print((hello == "Hello") + " ");

        System.out.print((hello == ("Hel"+"lo")) + " ");

        System.out.print((hello == ("Hel"+lo)) + " ");

        System.out.println(hello == ("Hel"+lo).intern());
    }

}
