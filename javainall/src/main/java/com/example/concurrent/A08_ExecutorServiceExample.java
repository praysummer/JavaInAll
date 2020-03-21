package com.example.concurrent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class A08_ExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // newFixedThreadPool  Runnable task
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        fixedThreadPool.execute(new Runnable() {
            public void run() {
                System.out.println("fixedThreadPool execute runnable task");
            }
        });
        fixedThreadPool.shutdown();
        System.out.println("--------------------");

        // newFixedThreadPool  Callable task
        ExecutorService fixedThreadPool1 = Executors.newFixedThreadPool(2);
        Set<Callable<String>> set = new HashSet<>();
        set.add(new Callable<String>() {
            public String call() throws Exception {
                return "Callable Task 1";
            }
        });

        set.add(new Callable<String>() {
            public String call() throws Exception {
                return "Callable Task 2";
            }
        });
        set.add(new Callable<String>() {
            public String call() throws Exception {
                return "Callable Task 3";
            }
        });
        String result = fixedThreadPool1.invokeAny(set);
        System.out.println("fixedThreadPool1 result = " + result);
        fixedThreadPool1.shutdown();
        System.out.println("--------------------");

        //newSingleThreadExecutor
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        Future<Object> future = singleThreadExecutor.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("singleThreadExecutor execute Callable task");
                return "Callable Result";
            }
        });
        System.out.println("singleThreadExecutor future.get() = " + future.get());
        System.out.println("singleThreadExecutor future.isDone() = " + future.isDone());
        singleThreadExecutor.shutdown();
        System.out.println("--------------------");


        ExecutorService singleThreadExecutor1 = Executors.newSingleThreadExecutor();
        Set<Callable<String>> callables = new HashSet<>();
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 1";
            }
        });

        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 2";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 3";
            }
        });
        List<Future<String>> list = singleThreadExecutor1.invokeAll(callables);
        for (Future<String> f : list)
            System.out.println("result = " + f.get());

        singleThreadExecutor1.shutdown();
        System.out.println("--------------------");

        //newScheduledThreadPool
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(5);
        scheduledExecutorService.schedule(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("Executed!");
                return "Called!";
            }
        }, 5, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();
        System.out.println("--------------------");


        //创建等待队列
        BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);
        //创建线程池，池中保存的线程数为3，允许的最大线程数为5
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,5,50,TimeUnit.MILLISECONDS,bqueue);

        pool.execute(new Runnable() {
            public void run() {
                System.out.println("ThreadPoolExecutor execute runnable task!");
            }
        });
        pool.shutdown();
    }
}
