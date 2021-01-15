package com.aac.q0001.twosum;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

/**
 * Created by He at 11:33 2019/5/11
 */
public class Solution {
    private Map<Integer, Integer> dictionary;

    public int[] twoSum(int[] nums, int target) {
        dictionary = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (dictionary.containsKey(target - nums[i]))
                return new int[] {dictionary.get(target - nums[i]), i};
            else
                dictionary.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        for (int i : new Solution().twoSum(new int[]{-10, -1, -18, -19}, -19)) {
            System.out.println(i);
        }
        System.out.println();

        char[] a = new char[10];
        a[0] = '1';
        a[1] = '\0';
        a[2] = '1';

        System.out.println(new String(a));
    }

//    class Filter implements Lock {
//        int[] level;
//        int[] victim;
//        int n, l;
//        int levelCapacity = n - l + 1 > 0 ? n - l + 1 : 0;
//
//        public Filter(int levelCapacity) {
//            level = new int[levelCapacity];
//            victim = new int[levelCapacity]; // use 1..n-1
//            for (int i = 0; i < levelCapacity; i++) {
//                level[i] = 0;
//            }
//        }
//
//        public void lock() {
//            int me = ThreadID.get();
//            for (int i = 1; i < levelCapacity; i++) { // attempt level i
//                level[me] = i;
//                victim[i] = me;
//                // spin while conflicts exist
//                int m;
//                do {
//                    m = 0;
//                    for(int j = 0;j < n;++j) {
//                        if(level[j] >= i)
//                            m++;
//                    }
//                } while (m > l && victim[i] == me);
//            }
//        }
//
//        public void unlock() {
//            int me = ThreadID.get();
//            level[me] = 0;
//        }
//    }
//
//    AtomicInteger
//
//    public class Assign23<T> {
//        AtomicReference<T>[] r = (AtomicReference<T>[]) new Object[3];
//
//        public Assign23(T init) {
//            for (int i = 0; i < r.length; i++)
//                r[i] = new AtomicReference<T>(init);
//        }
//
//        public synchronized void assign(T v0, T v1, int i0, int i1) {
//            T t0 = r[i0].get();
//            T t1 = r[i1].get();
//            r[i0].compareAndSet(t0, v0);
//            r[i1].compareAndSet(t0, v0);
//        }
//
//        public synchronized T read(int i) {
//            return r[i].get();
//        }
//    }
//
//
//
//    class Counter {
//        MSMRReg[] regs = new MSMRReg[N];
//        ThreadLocal<Integer> myIndex;
//        int sum = 0;
//
//        int read() {
//            sum = 0;
//            for (MSMRReg j : regs) {
//                sum += j.read();
//            }
//            return sum;
//        }
//
//        void inc() {
//            int i = myIndex.get();
//            int tmp = regs[i].read() + 1;
//            regs[i].write(tmp);
//        }
//    }
//
//    public boolean isLocked() {
//        return state.get();
//    }
//
//    public boolean isLocked() {
//        return tail.get().locked;
//    }
//
//    public boolean isLocked() {
//        QNode qnode = tail.get();
//        return qnode != null && qnode.locked;
//    }
//
//
//    public static final int N = 5;
//    public static HungerPerson[] people = new HungerPerson[N];
//    public void feed_next(int id) {
//        int next = (id + 1) / N;
//        for (;;) {
//            people[next].feed();
//        }
//    }

}