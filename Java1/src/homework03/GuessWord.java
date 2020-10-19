package homework03;

import java.util.Random;
import java.util.Scanner;

/*
* Создать массив из слов
String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно можно пользоваться:
String str = "apple";
char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово.
Используем только маленькие буквы.
*/

public class GuessWord {

    private static Scanner scanner = new Scanner(System.in);
    private static Random random   = new Random();
    private static String[] words  = {"apple"   , "orange"  , "lemon"    ,"banana" , "apricot",
                                      "avocado" , "broccoli", "carrot"   , "cherry" , "garlic",
                                      "grape"   , "melon"   , "leak"     , "kiwi"   , "mango",
                                      "mushroom", "nut"     , "olive"    , "pea"    , "peanut",
                                      "pear"    , "pepper"  , "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {

        String word  = words[random.nextInt(words.length)];
        char[] chars = word.toCharArray();
        boolean win  = false;

        while (!win) {

            System.out.println("Ваша догадка...");
            String userWord = scanner.nextLine().toLowerCase();
            char[] userChars = userWord.toCharArray();

            if (userWord.equals(word)) {
                win = true;
            } else {

                for (int i = 0; i < 15; i++) {
                    if (i >= Math.min(chars.length, userChars.length)) {
                        System.out.print("#");
                    } else {
                        if (chars[i] == userChars[i])
                            System.out.print(chars[i]);
                        else
                            System.out.print("#");
                    }
                }
                System.out.println();
            }

        }

        System.out.println("Вы угадали слоово!");

    }

}
