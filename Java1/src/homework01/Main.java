package homework01;

public class Main {

    // 2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
    private static byte   bt = 1;
    private static short  sh = 2;
    private static int    it = 3;
    private static long   lg = 4L;
    private static float  ft = 5.0f;
    private static double db = 6.0;
    private static char   ch = '7';

    // 1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {

    }

    // 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
    public static double calculate(int a, int b, int c, int d) {
        return a * (b + ((double) c / d));
    }

    // 4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
    // если да – вернуть true, в противном случае – false;
    public static boolean isRange(int a, int b) {
        return (a + b) > 10 && (a + b) <= 20;
    }

    // 5. Написать метод, которому в качестве параметра передается целое число,
    // метод должен напечатать в консоль положительное ли число передали, или отрицательное;
    // Замечание: ноль считаем положительным числом.
    public static void isPositive(int a) {
        System.out.println(a < 0 ? "Negative" : "Positive");
    }

    // 6. Написать метод, которому в качестве параметра передается целое число,
    // метод должен вернуть true, если число отрицательное;
    public static boolean isNegative(int a) {
        return a < 0;
    }

    // 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
    // метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    public static void printName(String name) {
        System.out.println("Привет, " + name + "!");
    }

    // 8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static void isLeap(int year) {
        String result = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)  ? "Leap" : "NotLeap";
        System.out.println(result);
    }

}
