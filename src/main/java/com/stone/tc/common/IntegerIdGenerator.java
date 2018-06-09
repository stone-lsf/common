package com.stone.tc.common;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shifeng.luo
 * @version created on 2018/6/9 下午8:28
 */
public class IntegerIdGenerator {

    private AtomicInteger count = new AtomicInteger(0);

    public IntegerIdGenerator() {
    }

    public IntegerIdGenerator(int initId) {
        count.set(initId);
    }

    public int nextId() {
        return count.incrementAndGet();
    }

    public int current() {
        return count.get();
    }

    public int preId() {
        return current() - 1;
    }
}
