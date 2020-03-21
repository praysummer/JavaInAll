package com.example.concurrent;


import java.util.concurrent.CountDownLatch;

public class A05_CountDownLatchExample {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        Waiter waiter = new Waiter(latch);
        Decrementer decrementer = new Decrementer(latch);

        new Thread(waiter).start();
        new Thread(decrementer).start();

    }

}

