package com.example.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class A02_DelayQueueExample {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<DelayedTask> delayqueue = new DelayQueue<>();
        long now = 0;
        delayqueue.put(new DelayedTask(now+3000));
        delayqueue.put(new DelayedTask(now+4000));
        delayqueue.put(new DelayedTask(now+6000));
        delayqueue.put(new DelayedTask(now+1000));
        System.out.println(delayqueue);

        for(int i=0; i<4; i++) {
            System.out.println(delayqueue.take());
        }
    }
}
