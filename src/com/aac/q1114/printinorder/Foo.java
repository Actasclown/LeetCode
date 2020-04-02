package com.aac.q1114.printinorder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Foo {

//    Semaphore run2 = new Semaphore(0);
//    Semaphore run3 = new Semaphore(0);
//
//    public Foo() {
//
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        run2.release();
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        run2.acquire();
//        printSecond.run();
//        run3.release();
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//
//        // printThird.run() outputs "third". Do not change or remove this line.
//        run3.acquire();
//        printThird.run();
//    }

    boolean firstPrinted = false;
    boolean secondPrinted = false;

    public Foo() {

    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstPrinted = true;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while(!firstPrinted)
            wait();
        printSecond.run();
        secondPrinted = true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while(!secondPrinted)
            wait();
        printThird.run();
    }

    public static void main(String[] args) {
        Runnable first = () ->  {
            System.out.println("first");
        };

        Runnable second = () -> {
            System.out.println("second");
        };

        Runnable third = () -> {
            System.out.println("third");
        };

        Foo foo = new Foo();

        Thread t1 = new Thread(() -> {
            try {
                foo.second(second);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                foo.first(first);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                foo.third(third);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
