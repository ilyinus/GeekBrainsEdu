package homework03;

import java.util.Random;
import java.util.Scanner;

/*
Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
*/

public class GuessNumber {

    private static final int TRY_COUNT = 3;
    private static Scanner scanner     = new Scanner(System.in);
    private static Random random       = new Random();

    public static void main(String[] args) {

        System.out.println("Привет! Давай неменого поиграем?\n" +
                           "Компьютер загадал число от 0 до 9.\n" +
                           "Попробуй угадать! Удачи :)\n");

        while (true) {

            int number  = random.nextInt(10);
            boolean win = false;

            for (int i = 0; i < TRY_COUNT; i++) {

                System.out.println("Введите вашу догадку...");

                int userNumber = scanner.nextInt();
                win = userNumber == number;

                if (win) {
                    break;
                } else if (i < TRY_COUNT - 1) {
                    System.out.println("Загаданное число " + (userNumber > number ? "меньше" : "больше"));
                }

            }

            if (win)
                System.out.println("Вы выйграли!");
            else
                System.out.println("Не угадали! Компьютер загадал число " + number);

            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");

            if (scanner.nextInt() == 0) {
                System.out.println("До новых встреч!");
                break;
            }

        }

    }

}
