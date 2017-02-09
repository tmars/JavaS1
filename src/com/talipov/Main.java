package com.talipov;

public class Main {
    public int seconds;

    public static void main(String[] args) {
        Counter counter = new Counter();

        Waiter waiter1 = new Waiter(counter, 5);
        new Thread(waiter1).start();

        Waiter waiter2 = new Waiter(counter, 7);
        new Thread(waiter2).start();

        Timer timer = new Timer(counter);
        new Thread(timer).start();

        System.out.println("Стартовали");
    }
}
