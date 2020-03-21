package com.example.concurrent;


import java.util.concurrent.Semaphore;

public class A07_SemaphoreExample {

    public static void main(String[]args){
        Semaphore semaphore = new Semaphore(3);

        new Thread(new ThreadSemaphore(semaphore)).start();
        new Thread(new ThreadSemaphore(semaphore)).start();
        new Thread(new ThreadSemaphore(semaphore)).start();
        new Thread(new ThreadSemaphore(semaphore)).start();
        new Thread(new ThreadSemaphore(semaphore)).start();

    }

}

