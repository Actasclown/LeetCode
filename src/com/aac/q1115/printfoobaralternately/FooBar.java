package com.aac.q1115.printfoobaralternately;

import java.util.concurrent.*;

public class FooBar {
    private int n;

    Semaphore s1 = new Semaphore(0);
    Semaphore s2 = new Semaphore(1);


    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            s2.acquire();
            printFoo.run();
            s1.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            s1.acquire();
            printBar.run();
            s2.release();
        }
    }

//    private int n;
//    CyclicBarrier cyclicBarrier;
//
//    public FooBar(int n) {
//        this.n = n;
//        cyclicBarrier = new CyclicBarrier(2);
//    }
//
//    public void foo(Runnable printFoo) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//
//            // printFoo.run() outputs "foo". Do not change or remove this line.
//            printFoo.run();
//            try {
//                cyclicBarrier.await();
//            } catch (BrokenBarrierException e) {
//
//            }
//        }
//    }
//
//    public void bar(Runnable printBar) throws InterruptedException {
//
//        for (int i = 0; i < n; i++) {
//
//            // printBar.run() outputs "bar". Do not change or remove this line.
//            printBar.run();
//            try {
//                cyclicBarrier.await();
//            } catch (BrokenBarrierException e) {
//
//            }
//        }
//    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(3);
        Runnable printFoo = () -> {System.out.print("foo");};
        Runnable printBar = () -> {System.out.print("bar");};
//        Thread thread1 = new Thread(() -> {
//            try {
//                fooBar.bar(printBar);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } ;
//        });
//        Thread thread2 = new Thread(() -> {
//            try {
//                fooBar.foo(printFoo);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } ;
//        });
//        thread1.start();
//        thread2.start();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(()-> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
            e.printStackTrace();
            }
        });
        executorService.submit(()-> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
