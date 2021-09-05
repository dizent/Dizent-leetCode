package leetCode.aliexam;

import java.util.concurrent.*;
import java.util.function.IntConsumer;

/**
 * @Auther: 布谷
 * @Date: 2021/8/27 14:17
 * @Description:
 */
public class SolutionThread {

    public static void main(String[] args) {
        new SolutionThread(100).run();
    }

    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            try {
                odd(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                even(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private int n;
    private Semaphore oddSema = new Semaphore(0);//奇数
    private Semaphore evenSema = new Semaphore(0);//偶数

    public SolutionThread(int n) {
        this.n = n;
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 0) {//偶数 打印偶数 并释放zero的线程
                evenSema.acquire();
                printNumber.accept(i);
                oddSema.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 1) {//奇数，打印奇数，并释放zero的线程
//                oddSema.acquire();
                printNumber.accept(i);
                evenSema.release();
            }
        }
    }

}
