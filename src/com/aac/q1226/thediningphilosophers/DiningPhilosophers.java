package com.aac.q1226.thediningphilosophers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

////  Method 1 : Allow 4 at most pick up left at the same time.
//    public DiningPhilosophers() {
//        locks = new Semaphore[5];
//        for (int i = 0; i < 5; i++) {
//            locks[i] = new Semaphore(1);
//        }
//        mutex = new Semaphore(4);
//    }
//
//    Semaphore[] locks;
//    Semaphore mutex;
//
//    // call the run() method of any runnable to execute its code
//    public void wantsToEat(int philosopher,
//                           Runnable pickLeftFork,
//                           Runnable pickRightFork,
//                           Runnable eat,
//                           Runnable putLeftFork,
//                           Runnable putRightFork) throws InterruptedException {
//
//        int left = philosopher % 5;
//        int right = (philosopher + 1) % 5;
//
//        mutex.acquire();
//        locks[left].acquire();
//        locks[right].acquire();
//
//        pickLeftFork.run();
//        pickRightFork.run();
//        eat.run();
//        putRightFork.run();
//        putLeftFork.run();
//
//        locks[left].release();
//        locks[right].release();
//        mutex.release();
//    }

////  Method 2 : pick up both successfully, then eat
//    public DiningPhilosophers() {
//        locks = new Semaphore[5];
//        for (int i = 0; i < 5; i++) {
//            locks[i] = new Semaphore(1);
//        }
//    }
//
//    Semaphore[] locks;
//
//    // call the run() method of any runnable to execute its code
//    public void wantsToEat(int philosopher,
//                           Runnable pickLeftFork,
//                           Runnable pickRightFork,
//                           Runnable eat,
//                           Runnable putLeftFork,
//                           Runnable putRightFork) throws InterruptedException {
//
//        int left = philosopher % 5;
//        int right = (philosopher + 1) % 5;
//
//        locks[left].acquire();
//        locks[right].acquire();
//
//        try {
//            pickLeftFork.run();
//            pickRightFork.run();
//            eat.run();
//            putRightFork.run();
//            putLeftFork.run();
//        }
//        finally {
//            locks[left].release();
//            locks[right].release();
//        }
//    }

////  Method 2 : II
//    public DiningPhilosophers() {
//        locks = new Semaphore[5];
//        for (int i = 0; i < 5; i++) {
//            locks[i] = new Semaphore(1);
//        }
//        mutex = new Semaphore(1);
//    }
//
//    Semaphore[] locks;
//    Semaphore mutex;
//
//    // call the run() method of any runnable to execute its code
//    public void wantsToEat(int philosopher,
//                           Runnable pickLeftFork,
//                           Runnable pickRightFork,
//                           Runnable eat,
//                           Runnable putLeftFork,
//                           Runnable putRightFork) throws InterruptedException {
//
//        int left = philosopher % 5;
//        int right = (philosopher + 1) % 5;
//
//        mutex.acquire();
//        locks[left].acquire();
//        locks[right].acquire();
//        mutex.release();
//
//        pickLeftFork.run();
//        pickRightFork.run();
//        eat.run();
//        putRightFork.run();
//        putLeftFork.run();
//
//        locks[left].release();
//        locks[right].release();
//    }

//  Method 2 : III
    public DiningPhilosophers() {
        locks = new ArrayList<>();
        for(int i = 0;i < 5;++i) {
            locks.add(new ReentrantLock());
        }
    }

    List<ReentrantLock> locks;

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        synchronized (locks) {
            locks.get(philosopher).lock();
            locks.get((philosopher + 1) % 5).lock();
        }

        try {
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putRightFork.run();
            putLeftFork.run();
        }
        finally {
            locks.get(philosopher).unlock();
            locks.get((philosopher + 1) % 5).unlock();
        }
    }

//  Method 3 : Odds pick up left first, evens pick up right first
//    public DiningPhilosophers() {
//        this.forks = new Semaphore[5];
//        for (int i = 0;i < 5;++i) {
//            forks[i] = new Semaphore(1);
//        }
//    }
//
//    Semaphore[] forks;
//
//    // call the run() method of any runnable to execute its code
//    public void wantsToEat(int philosopher,
//                           Runnable pickLeftFork,
//                           Runnable pickRightFork,
//                           Runnable eat,
//                           Runnable putLeftFork,
//                           Runnable putRightFork) throws InterruptedException {
//        int left = philosopher % 5;
//        int right = (philosopher + 1) % 5;
//        if(philosopher % 2 == 0) {
//            forks[left].acquire();
//            forks[right].acquire();
//            pickLeftFork.run();
//            pickRightFork.run();
//            eat.run();
//            putRightFork.run();
//            putLeftFork.run();
//            forks[right].release();
//            forks[left].release();
//        } else {
//            forks[right].acquire();
//            forks[left].acquire();
//            pickRightFork.run();
//            pickLeftFork.run();
//            eat.run();
//            putLeftFork.run();
//            putRightFork.run();
//            forks[left].release();
//            forks[right].release();
//        }
//    }
}