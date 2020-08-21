package leetCode.easy.printInOrder;

import java.util.concurrent.CountDownLatch;


/**
 * 我们提供了一个类：
 *
 * public class Foo {
 *  public void first() { print("first"); }
 *  public void second() { print("second"); }
 *  public void third() { print("third"); }
 * }
 * 三个不同的线程将会共用一个Foo实例。
 *
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用second() 方法
 * 线程 C 将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 *
 * 
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: "firstsecondthird"
 * 解释: 
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
 * 正确的输出是 "firstsecondthird"。
 * 示例 2:
 *
 * 输入: [1,3,2]
 * 输出: "firstsecondthird"
 * 解释: 
 * 输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。
 * 正确的输出是 "firstsecondthird"。
 * 
 *
 * 提示：
 *
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * 你看到的输入格式主要是为了确保测试的全面性。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 */
public class Foo {

    /**
     * 思路：这是一道多线程题
     *
     * 使用countDownLatch计数器来保障线程在达到条件后再执行。
     */
    public Foo() {
    }

    CountDownLatch countDownLatch1 = new CountDownLatch(1);
    CountDownLatch countDownLatch2 = new CountDownLatch(1);


    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        countDownLatch1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        countDownLatch2.countDown();
    }


    public void third(Runnable printThird) throws InterruptedException {
        countDownLatch2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
