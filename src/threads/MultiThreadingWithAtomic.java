package threads;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Ejaskhan
 **/
public class MultiThreadingWithAtomic {

    AtomicInteger integer = new AtomicInteger(0);

    public void firstMethod() {
        System.out.println("first");
        HashMap<String,String> map=new HashMap<>();

        notifyAll();
        integer.incrementAndGet();
    }

    public void secondMethod() throws InterruptedException {
        while (integer.get() != 1) {
            Thread.sleep(100);
        }
        System.out.println("second");
        integer.incrementAndGet();
    }

    public void thirdMethod() throws InterruptedException {
        while (integer.get() != 2) {
            Thread.sleep(100);
        }
        System.out.println("third");
        integer.incrementAndGet();
    }

    public void fourthMethod() throws InterruptedException {
        while (integer.get() != 3) {
            Thread.sleep(100);
        }
        System.out.println("Fourth");
    }
}

class MultiThreadingWithAtomicMain {
    public static void main(String[] args) throws InterruptedException {
        MultiThreadingWithAtomic obj
                = new MultiThreadingWithAtomic();


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.firstMethod();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.secondMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.thirdMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.fourthMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

}
