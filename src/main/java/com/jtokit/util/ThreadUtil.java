package com.jtokit.util;

public class ThreadUtil {
    private ThreadUtil() {

    }


    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void runInThread(Runnable runnable) {
        new Thread(runnable).start();
    }
}
