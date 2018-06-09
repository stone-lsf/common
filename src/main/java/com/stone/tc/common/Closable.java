package com.stone.tc.common;

/**
 * @author shifeng.luo
 * @version created on 2018/6/9 下午1:02
 */
public interface Closable {

    /**
     * stop method，may throw unchecked exception
     */
    void close();
}
