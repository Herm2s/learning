package com.hermes.heima_juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liu.zongbin
 * @since 2022/9/4 21:09
 */
public class AccountSafe implements Account {

    private AtomicInteger balance;

    public AccountSafe(Integer balance) {
        this.balance = new AtomicInteger(balance);
    }

    @Override
    public synchronized Integer getBalance() {
        return balance.get();
    }

    @Override
    public synchronized void withdraw(Integer amount) {
        // 核心代码
        while (true) {
            int pre = getBalance();
            int next = pre - amount;
            if (balance.compareAndSet(pre, next)) {
                break;
            }
        }
        // 可以简化为下面的方法
        // balance.addAndGet(-amount);
    }

    public static void main(String[] args) {
        Account.demo(new AccountSafe(10000));
    }
}
