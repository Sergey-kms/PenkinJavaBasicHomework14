package ru.java.basic.penkin.hw14;

public class SingleThreadedArrayFill {  // На гитхаб vetka1
    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        double[] array = new double[100_000_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - time;
        System.out.println("Время выполнения при одном потоке: " + executionTime + " мс");
    }
}