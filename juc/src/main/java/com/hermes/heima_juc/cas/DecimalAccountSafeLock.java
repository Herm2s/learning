package com.hermes.heima_juc.cas;

import java.math.BigDecimal;

/**
 * @author liu.zongbin
 * @since 2022/9/4 21:47
 */
public class DecimalAccountSafeLock implements DecimalAccount {

    private final Object lock = new Object();

    BigDecimal balance;

    public DecimalAccountSafeLock(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public void withdraw(BigDecimal amount) {
        synchronized (lock) {
            BigDecimal balance = this.getBalance();
            this.balance = balance.subtract(amount);
        }
    }

    public static void main(String[] args) {
        DecimalAccount.demo(new DecimalAccountSafeLock(new BigDecimal("10000")));
    }
}
