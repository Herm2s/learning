package com.hermes.heima_juc.cas;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liu.zongbin
 * @since 2022/9/4 21:47
 */
public class DecimalAccountSafeCas implements DecimalAccount {

    AtomicReference<BigDecimal> ref;

    public DecimalAccountSafeCas(BigDecimal balance) {
        ref = new AtomicReference<>(balance);
    }

    @Override
    public BigDecimal getBalance() {
        return ref.get();
    }

    @Override
    public void withdraw(BigDecimal amount) {
        while (true) {
            BigDecimal prev = ref.get();
            BigDecimal next = prev.subtract(amount);
            if (ref.compareAndSet(prev, next)) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        DecimalAccount.demo(new DecimalAccountUnsafe(new BigDecimal("10000")));
        DecimalAccount.demo(new DecimalAccountSafeLock(new BigDecimal("10000")));
        DecimalAccount.demo(new DecimalAccountSafeCas(new BigDecimal("10000")));
    }
}
