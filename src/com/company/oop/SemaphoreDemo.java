package com.company.oop;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = Semaphore.request();
        Semaphore semaphore1 = Semaphore.request();

        if (semaphore1 != null) {
            semaphore1.release();
            semaphore1 = null;
        }

        Semaphore semaphore2 = Semaphore.request();
    }
}
