package com.hermes.heima_juc.cas;

/**
 * @author liu.zongbin
 * @since 2022/9/4 21:09
 */
public class AccountUnsafe implements Account {

    private Integer balance;

    public AccountUnsafe(Integer balance) {
        this.balance = balance;
    }

    @Override
    public synchronized Integer getBalance() {
        return balance;
    }

    @Override
    public synchronized void withdraw(Integer amount) {
        balance -= amount;
    }

    public static void main(String[] args) {
        Account.demo(new AccountUnsafe(10000));
    }
}
