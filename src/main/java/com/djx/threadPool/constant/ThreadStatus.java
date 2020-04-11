package com.djx.threadPool.constant;

/**
 * 线程状态枚举
 */
public enum ThreadStatus {

    READY("就绪"),
    START("开始"),
    END("结束");

    private String name;

    ThreadStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
