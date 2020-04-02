package com.aac.q1116.printzeroevenodd;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    private boolean oddToPrint = true;

    Semaphore printZero = new Semaphore(1);
    Semaphore printEven = new Semaphore(0);
    Semaphore printOdd = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            printZero.acquire();
            printNumber.accept(0);
            if(oddToPrint)
                printOdd.release();
            else
                printEven.release();
            oddToPrint = !oddToPrint;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            printEven.acquire();
            printNumber.accept(i);
            printZero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            printOdd.acquire();
            printNumber.accept(i);
            printZero.release();
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(6);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(()-> {
            try {
                zeroEvenOdd.zero((int x)-> System.out.println(x));
            } catch (InterruptedException e) {

            }
        });
        executorService.submit(()-> {
            try {
                zeroEvenOdd.odd((int x)-> System.out.println(x));
            } catch (InterruptedException e) {

            }
        });
        executorService.submit(()-> {
            try {
                zeroEvenOdd.even((int x)-> System.out.println(x));
            } catch (InterruptedException e) {

            }
        });
    }
}