package homework02;

import java.util.Arrays;

public class Main {

    // 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0.
    public static void binaryArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 - arr[i];
        }

        System.out.println(Arrays.toString(arr));

    }

    // 2. Задать пустой целочисленный массив размером 8.
    // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21.
    public static void fillArray() {
        int[] arr = new int[8];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }

        System.out.println(Arrays.toString(arr));
    }

    // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
    // пройти по нему циклом и числа меньшие 6 умножить на 2.
    public static void changeArrayValues() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6)
                arr[i] = arr[i] * 2;
        }

        System.out.println(Arrays.toString(arr));

    }

    // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
    // и с помощью цикла (-ов) заполнить его диагональные элементы единицами.
    public static void fillMatrix() {
        int[][] matrix = new int[10][10];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
            matrix[i][matrix.length - 1 - i] = 1;
        }

        for (int[] rows : matrix) {
            for (int columns : rows) {
                System.out.print("[" + columns + "]\t");
            }
            System.out.println();
        }

    }

    // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void minMax() {
        int[] arr = {5, 1, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int min = arr[0];
        int max = arr[0];

        for (int value : arr) {
            min = Math.min(value, min);
            max = Math.max(value, max);
        }

        System.out.println("Min: " + min + "\nMax: " + max);

    }

    // 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    // checkBalance([1, 1, 1, || 2, 1]) → true,
    // граница показана символами ||, эти символы в массив не входят.
    public static boolean checkBalance(int[] arr) {

        int sumLeft  = 0;
        int sumRight = 0;
        int middle   = arr.length / 2;
        boolean even = (arr.length % 2) == 0;

        // Начнем двигаться по массиву от его концов к середине суммирая результаты
        for (int i = 0; i < middle; i++) {
            sumLeft  += arr[i];
            sumRight += arr[arr.length - i - 1];
        }

        // Если число элементов массива нечетное, то докинем не вошедший
        // серединный элемент, например, в правую часть
        if (!even)
            sumRight += arr[middle];

        // Если суммы не равны, то попробуем найти баланс сдвигаясь от "середины"
        // влево или вправо, в зависимости от того, какая часть оказалась больше
        if (sumLeft < sumRight) {
            for (int i = middle; i < arr.length; i++) {
                sumLeft  += arr[i];
                sumRight -= arr[i];
                if (sumLeft >= sumRight)
                    break;
            }
        } else if (sumLeft > sumRight) {
            for (int i = middle - 1; i >= 0; i--) {
                sumLeft  -= arr[i];
                sumRight += arr[i];
                if (sumLeft <= sumRight)
                    break;
            }
        }

        return sumLeft == sumRight;

    }

    // 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    // при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    // При каком n в какую сторону сдвиг можете выбирать сами.
    public static void swapArray(int[] arr, int n) {

        int startIndex   = 0;      // Стартовый индекс. Нужен для отслеживания закольцевания
        int currentIndex = 0;      // Индекс элемента, который сейчас в буфере
        int currentValue = arr[0]; // Буфер для значения

        // Пройдем по массиву 1 раз и сразу будем перемещать элементы в нужные места
        for (int i : arr) {

            int newIndex, temp;

            // Вычисляем индекс, куда перемещать текущий элемент
            newIndex = (currentIndex + n) % arr.length;
            newIndex = newIndex < 0 ? arr.length + newIndex : newIndex;

            // Если вдруг вернулись в ту же точку до окончания основного цикла,
            // то возьмем следующий индекс от стартового, иначе так и будт ходить по кругу.
            // В противном случае просто перемещаем элемент из буфера в новое место массива,
            // а в буфер помещаем новый элемент.
            if (newIndex == startIndex) {
                arr[newIndex] = currentValue;
                currentIndex  = ++startIndex;
                currentValue  = arr[currentIndex];
            } else {
                temp          = arr[newIndex];
                arr[newIndex] = currentValue;
                currentValue  = temp;
                currentIndex  = newIndex;
            }

        }

        System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args) {
        binaryArray();
        fillArray();
        changeArrayValues();
        fillMatrix();
        minMax();
        System.out.println(checkBalance(new int[]{5, 2, 1, 1, 1}));
        swapArray(new int[]{1, 2, 3, 4}, -2);
    }

}
