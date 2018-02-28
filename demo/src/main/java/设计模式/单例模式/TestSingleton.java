package 设计模式.单例模式;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSingleton {
    
    boolean lock ;
    
    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    private  static int num = 0;
    public static void main(String[] args) throws InterruptedException {
        final Set<String> instanceSet = Collections.synchronizedSet(new HashSet<String>());
        final TestSingleton lock = new TestSingleton();
        lock.setLock(true);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                
                public void run() {
                    while (true) {
                        num++;
                        System.out.println("---------");
                        if (!lock.isLock()) {
                            System.out.println("========");
                            System.out.println(num);
                            Singleton singleton = Singleton.getInstance();
                            instanceSet.add(singleton.toString());
                            System.out.println("========..");
                            break;
                        }
                        System.out.println("---..");
                    }
                }
            });
        }
        Thread.sleep(5000);
        lock.setLock(false);
        Thread.sleep(5000);
        System.out.println("------并发情况下我们取到的实例------");
        for (String instance : instanceSet) {
            System.out.println(instance);
        }
        executorService.shutdown();
    }
}
