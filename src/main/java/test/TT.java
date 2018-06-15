package test;

/**
 * @Description：TODO
 * @Author wb-zmx300072 2018/1/4 17:02
 */
public class TT {

  public static class QQ{
      public  static Resource resource = new Resource();
  }
  public static Resource getResource(){
      return QQ.resource;
  }

    public static void main(String[] args) {

    }

}
class  Resource{
    Resource(){
        System.out.println("Resource 实例化");
    }
}
