package com.aac.q1117.buildingh2o;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class H2O {

//    public H2O() {
//
//    }
//
//    Semaphore hydrogen = new Semaphore(2);
//    Semaphore oxydrogen = new Semaphore(0);
//
//    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
//
//        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
//        hydrogen.acquire();
//        releaseHydrogen.run();
//        oxydrogen.release();
//    }
//
//    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
//
//        // releaseOxygen.run() outputs "O". Do not change or remove this line.
//        oxydrogen.acquire(2);
//        releaseOxygen.run();
//        hydrogen.release(2);
//    }


    public H2O() {

    }

    AtomicInteger atomicInteger = new AtomicInteger(0);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        while(! (atomicInteger.compareAndSet(0, 1) || atomicInteger.compareAndSet(1, 2)))
            wait();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        notifyAll();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        while(!(atomicInteger.compareAndSet(2, 0)))
            wait();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        notifyAll();
    }

}
