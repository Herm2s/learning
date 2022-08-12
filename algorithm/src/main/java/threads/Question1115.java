package threads;

/**
 * 题号1115
 * 交替打印foobar
 *
 * @author liu.zongbin
 * @since 2022/8/12
 */
public class Question1115 {

    private final int n;

    private volatile boolean isFoo = true;

    public Question1115(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                while (!isFoo) {
                    this.wait();
                }
                printFoo.run();
                isFoo = false;
                this.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                while (isFoo) {
                    this.wait();
                }
                printBar.run();
                isFoo = true;
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Question1115 foo = new Question1115(3);
        new Thread(() -> {
            try {
                foo.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                foo.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
