package homework01;

import java.util.ArrayList;
import java.util.Arrays;

public class Task2 {

    private static <T> ArrayList<T> transformToArrayList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    public static void main(String[] args) {
        String[] arr = {"1", "2", "3"};
        System.out.println(transformToArrayList(arr));
    }

}
