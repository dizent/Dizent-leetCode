package leetCode.regular.FooBar;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void execute(){

        Executor executor = Executors.newFixedThreadPool(2);
        executor.execute(()->{
            try {
                foo(() -> {
                    System.out.print("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(()->{
            try {
                bar(() -> {
                    System.out.print("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }


    private CountDownLatch a = new CountDownLatch(1);
    private CyclicBarrier barrier = new CyclicBarrier(2);


    public void foo(Runnable printFoo) throws InterruptedException {
        try {
            for (int i = 0; i < n; i++) {

                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                a.countDown();
                barrier.await();
            }
        } catch (Exception e) {
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        try {
            for (int i = 0; i < n; i++) {
                a.await();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                if(i != n-1) {
                    a = new CountDownLatch(1);
                    barrier.await();
                }
            }
        } catch (Exception e) {
        }

    }

    public static void main(String[] args) {
        int n = 5;
        new FooBar(n).execute();
    }
}
