package threads;

import javax.print.attribute.standard.PrinterURI;
import java.util.function.IntConsumer;

/**
 * @author liu.zongbin
 * @since 2022/8/12
 */
public class Question1116 {

    private int n;

    private volatile int next = 0;

    private volatile int isEven = 1;

    public Question1116(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (next != 0) {
                    this.wait();
                }
                printNumber.accept(n);
                next = 1;
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (isEven == 1) {
                printNumber.accept(n);
                next = 0;
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        printNumber.accept(n);
        next = 0;
    }

    public static void main(String[] args) {
        Question1116 question = new Question1116(10);
        new Thread(() -> {
            try {
                question.zero(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "zero").start();

        new Thread(() -> {
            try {
                question.even(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "even").start();
        new Thread(() -> {
            try {
                question.odd(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "odd").start();
    }
}
