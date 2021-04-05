package com.aac.q0622.designcircularqueue;

public class MyCircularQueue {

    int[] queue;
    int size;
    int front;
    int last;
    boolean empty;

    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.size = k;
        this.front = 0;
        this.last = 0;
        this.empty = true;
    }

    public boolean enQueue(int value) {
        if(this.isFull())
            return false;
        else {
            if(this.isEmpty()) {
                this.empty = false;
            } else {
                this.last += this.size;
                this.last -= 1;
                this.last %= this.size;
            }
            this.queue[this.last] = value;
            return true;
        }
    }

    public boolean deQueue() {
        if(this.isEmpty())
            return false;
        else {
            if(this.front == this.last) {
                this.empty = true;
            } else {
                this.front += this.size;
                this.front -= 1;
                this.front %= this.size;
            }
            return true;
        }
    }

    public int Front() {
        if(this.isEmpty())
            return -1;
        return this.queue[this.front];
    }

    public int Rear() {
        if(this.isEmpty())
            return -1;
        return this.queue[this.last];
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public boolean isFull() {
        if((this.front + 1) % this.size == this.last)
            return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
