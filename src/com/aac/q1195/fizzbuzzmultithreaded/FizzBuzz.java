package com.aac.q1195.fizzbuzzmultithreaded;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.function.IntConsumer;

public class FizzBuzz {

    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(int i = 1;i <= n;i++) {
            if(i % 5 != 0 && i % 3 == 0)
                printFizz.run();
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {

            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(int i = 1;i <= n;i++) {
            if(i % 3 != 0 && i % 5 == 0)
                printBuzz.run();
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {

            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

        for(int i = 1;i <= n;i++) {
            if(i % 15 == 0)
                printFizzBuzz.run();
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {

            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1;i <= n;i++) {
            if(i % 3 != 0 && i % 5 != 0)
                printNumber.accept(i);
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {

            }
        }
    }
}
