package notpint;

/**
 * @Description：TODO
 * @Author wb-zmx300072 2018/2/24 10:04
 */
public class t {

    public static void main(String[] args) {
        System.out.println(MessageTypeEnums.web.toString().equals("web"));
        System.out.println(MessageTypeEnums.contains("a"));
        System.out.println(MessageTypeEnums.contains("web"));
    }
}
