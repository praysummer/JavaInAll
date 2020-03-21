package com.example.concurrent;

import java.util.concurrent.*;

public class A04_BlockingDequedequeExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> deque = new LinkedBlockingDeque<String>();
        deque.addFirst("1");
        deque.addLast("2");
        String two = deque.takeLast();
        String one = deque.takeFirst();
        System.out.println(two);
        System.out.println(one);

        BlockingQueue queue   = new PriorityBlockingQueue();

        //String implements java.lang.Comparable
        queue.put("Value");

        String value = (String) queue.take();
        System.out.println(value);
    }


}
