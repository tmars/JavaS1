package com.talipov;

/**
 * Created by Марсель on 09.02.2017.
 */
public class Timer implements Runnable {
    private final Counter counter;

    public Timer(Counter c){
        this.counter = c;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                synchronized (this.counter) {
                    this.counter.incVal();
                    this.counter.notifyAll();
                    System.out.println("Прошло: " + this.counter.getVal());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
