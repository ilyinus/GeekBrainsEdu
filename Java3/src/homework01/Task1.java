package homework01;

import java.util.Arrays;

public class Task1 {

    private static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {
        String[] arr1 = {"1", "2", "3", "4"};
        Integer[] arr2 = {1, 2, 3, 4};

        swap(arr1, 0, 1);
        swap(arr2, 2, 3);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

    }

}
