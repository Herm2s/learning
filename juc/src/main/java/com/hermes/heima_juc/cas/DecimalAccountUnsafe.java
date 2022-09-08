package com.hermes.heima_juc.cas;

import java.math.BigDecimal;

/**
 * @author liu.zongbin
 * @since 2022/9/4 21:45
 */
public class DecimalAccountUnsafe implements DecimalAccount {

    BigDecimal balance;

    public DecimalAccountUnsafe(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public void withdraw(BigDecimal amount) {
        BigDecimal balance = this.getBalance();
        this.balance = balance.subtract(amount);
    }

    public static void main(String[] args) {
        DecimalAccount.demo(new DecimalAccountUnsafe(new BigDecimal("10000")));
    }
}
