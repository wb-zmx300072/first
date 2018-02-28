package test.InitializingBeanTest;

import org.springframework.beans.factory.InitializingBean;

/**
 * @Description：TODO
 * @Author wb-zmx300072 2017/12/6 16:15
 */
public class InitializingBeanTest implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet......");
    }

    public static void main(String[] args) {
        InitializingBeanTest initializingBeanTest = new InitializingBeanTest();
//        InitializingBeanTest initializingBeanTest = new InitializingBeanTest();

    }
}
