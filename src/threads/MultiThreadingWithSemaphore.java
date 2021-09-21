package threads;

import java.util.concurrent.Semaphore;

/**
 * @author Ejaskhan
 * use {@link Semaphore } to control the thread access to a resource
 * use {@link java.util.concurrent.CountDownLatch} to wait for the thread to complete
 **/
public class MultiThreadingWithSemaphore {

    final Semaphore runOne, runTwo, runThree;

    public MultiThreadingWithSemaphore() {
        this.runOne = new Semaphore(0);
        this.runTwo = new Semaphore(0);
        this.runThree =  new Semaphore(0);
    }

    public void firstMethod(Runnable runnable) {
        runnable.run();
        System.out.println("first");
        runOne.release();
    }

    public void secondMethod(Runnable runnable) throws InterruptedException {
        runOne.acquire();
        runnable.run();
        System.out.println("second");
        runTwo.release();
    }

    public void thirdMethod(Runnable runnable) throws InterruptedException {
        runTwo.acquire();
        System.out.println("third");
        runnable.run();
        runThree.release();
    }
    public void fourthMethod() throws InterruptedException {
        runThree.acquire();
        System.out.println("Fourth");

    }


}

class MultiThreadingWithSemaphoreMain {
    public static void main(String[] args) throws InterruptedException {
        MultiThreadingWithSemaphore obj
                = new MultiThreadingWithSemaphore();



        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.firstMethod(() -> new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("first");
                    }
                });
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.secondMethod(() -> new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("second");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.thirdMethod(() -> new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("third");
                        }
                    });
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
