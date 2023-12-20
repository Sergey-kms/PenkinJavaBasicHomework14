package ru.java.basic.penkin.hw14;

public class MultiThreadedArrayFill {  // На гит[аб vetka1
    public static void main(String[] args) throws InterruptedException {
        long time = System.currentTimeMillis();

        double[] array = new double[100_000_000];
        int numThreads = 4;
        int chunkSize = array.length / numThreads;

        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? array.length : (i + 1) * chunkSize;

            threads[i] = new Thread(() -> {
                for (int j = start; j < end; j++) {
                    array[j] = 1.14 * Math.cos(j) * Math.sin(j * 0.2) * Math.cos(j / 1.2);
                }
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - time;
        System.out.println("Время выполнения при многопоточности: " + executionTime + " мс");
    }
}