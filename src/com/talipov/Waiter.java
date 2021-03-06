package com.talipov;

/**
 * Created by Марсель on 09.02.2017.
 */
public class Waiter implements Runnable {
    private final Counter counter;
    private int shift;

    public Waiter(Counter c, int s){
        this.counter = c;
        this.shift = s;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        while (true) {
            synchronized (this.counter) {
                try {
                    this.counter.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.counter.getVal() % shift == 0) {
                    System.out.println("Alert!!! Thread: " + name);
                }
            }
        }
    }
}
