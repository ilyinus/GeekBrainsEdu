package homework05;

import java.util.Arrays;

public class Main {

    static final int size = 10_000_000;
    static final int h = size / 2;

    private static void method1() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Method#1: " + (System.currentTimeMillis() - startTime));

    }

    private static void method2() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        long startTime = System.currentTimeMillis();

        float[] half1 = new float[h];
        float[] half2 = new float[h];

        System.arraycopy(arr, 0, half1, 0, h);
        System.arraycopy(arr, h, half2, 0, h);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < half1.length; i++) {
                half1[i] = (float) (half1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < half2.length; i++) {
                half2[i] = (float) (half2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(half1, 0, arr, 0, h);
        System.arraycopy(half2, 0, arr, h, h);

        System.out.println("Method#2: " + (System.currentTimeMillis() - startTime));

    }

    public static void main(String[] args) {
        method1();
        method2();
    }

}
