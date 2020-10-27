package homework04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTakToe {

    private static final char DOT = '•';
    private static final char PLAYER_CHAR = 'X';
    private static final char COMPUTER_CHAR = 'O';
    private static final int CHARS_FOR_WIN = 4;
    private static final int SIZE = 5;
    private static final char[][] FIELD = new char[SIZE][SIZE];
    private static final Level level = Level.HARD;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static int x, y;

    private enum Level {
        EASY,
        HARD
    }

    private static void initField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                FIELD[i][j] = DOT;
            }
        }
    }

    private static void printField() {

        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print("\t" + (i + 1));
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < SIZE; j++) {
                System.out.print("\t" + FIELD[i][j]);
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {

        initField();
        printField();

        char currentPlayer = PLAYER_CHAR;
        int maxMoves = SIZE * SIZE;
        int moves = 0;

        while (true) {

            if (currentPlayer == PLAYER_CHAR)
                playerMove();
            else
                computerMove();

            if (isWin(currentPlayer)) {
                printEndGameInfo(currentPlayer);
                break;
            } else if (++moves == maxMoves) {
                printEndGameInfo(DOT);
                break;
            }

            currentPlayer = currentPlayer == PLAYER_CHAR ? COMPUTER_CHAR : PLAYER_CHAR;

        }

    }

    private static boolean isWin(char currentChar) {
        int chain = 0;

        // Проверяем горизонталь
        for (int i = (x - 1); i >= 0; i--) {
            chain += currentChar == FIELD[y - 1][i] ? 1 : 0;
            if (chain == CHARS_FOR_WIN)
                return true;
            else if (currentChar != FIELD[y - 1][i])
                break;
        }
        for (int i = x; i < SIZE; i++) {
            chain += currentChar == FIELD[y - 1][i] ? 1 : 0;
            if (chain == CHARS_FOR_WIN)
                return true;
            else if (currentChar != FIELD[y - 1][i])
                break;
        }

        chain = 0;

        // Проверяем вертикаль
        for (int i = (y - 1); i >= 0; i--) {
            chain += currentChar == FIELD[i][x - 1] ? 1 : 0;
            if (chain == CHARS_FOR_WIN)
                return true;
            else if (currentChar != FIELD[i][x - 1])
                break;
        }
        for (int i = y; i < SIZE; i++) {
            chain += currentChar == FIELD[i][x - 1] ? 1 : 0;
            if (chain == CHARS_FOR_WIN)
                return true;
            else if (currentChar != FIELD[i][x - 1])
                break;
        }

        chain = 0;

        // Проверяем диагональ слева направо
        // Сначало движемся влево вверх от точки куда сделали ход
        for (int i = y - 1, j = x - 1; i >= 0 && j >= 0; i--, j--) {
            chain += currentChar == FIELD[i][j] ? 1 : 0;
            if (chain == CHARS_FOR_WIN)
                return true;
            else if (currentChar != FIELD[i][j])
                break;
        }
        // Движемся вправо вниз от точки куда сделали ход
        for (int i = y, j = x; i < SIZE && j < SIZE; i++, j++) {
            chain += currentChar == FIELD[i][j] ? 1 : 0;
            if (chain == CHARS_FOR_WIN)
                return true;
            else if (currentChar != FIELD[i][j])
                break;
        }

        chain = 0;

        // Проверяем диагональ справо налево
        // Сначало движемся вправо вверх от точки куда сделали ход
        for (int i = y - 1, j = x - 1; i >= 0 && j < SIZE; i--, j++) {
            chain += currentChar == FIELD[i][j] ? 1 : 0;
            if (chain == CHARS_FOR_WIN)
                return true;
            else if (currentChar != FIELD[i][j])
                break;
        }
        // Движемся влево вниз от точки куда сделали ход
        for (int i = y, j = x - 2; i < SIZE && j >= 0; i++, j--) {
            chain += currentChar == FIELD[i][j] ? 1 : 0;
            if (chain == CHARS_FOR_WIN)
                return true;
            else if (currentChar != FIELD[i][j])
                break;
        }

        return false;
    }

    private static void printEndGameInfo(char winner) {
        if (winner == PLAYER_CHAR)
            System.out.println("Поздравляем! Вы победили!");
        else if (winner == COMPUTER_CHAR)
            System.out.println("Победил компьютер!");
        else
            System.out.println("Ничья!");
    }

    private static void computerMove() {

        if (level == Level.EASY) {

            stupidMove();

        } else if (level == Level.HARD) {

            smartMove();

        }

        System.out.println("Компьютер сделал ход");
        printField();
    }

    private static void stupidMove() {
        label:
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (FIELD[i][j] != DOT)
                    continue;
                else
                    FIELD[i][j] = COMPUTER_CHAR;
                x = j + 1;
                y = i + 1;
                break label;
            }
        }
    }

    private static void smartMove() {

        // Смотрим, а есть ли у нас выйгрышные ходы
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (FIELD[i][j] == DOT) {
                    if (checkHorizontal(i, j, COMPUTER_CHAR)) {
                        FIELD[i][j] = COMPUTER_CHAR;
                        return;
                    } else if (checkVertical(i, j, COMPUTER_CHAR)) {
                        FIELD[i][j] = COMPUTER_CHAR;
                        return;
                    } else if (checkDiagonal(i, j, COMPUTER_CHAR)) {
                        FIELD[i][j] = COMPUTER_CHAR;
                        return;
                    }
                }
            }
        }

        // Если игрок в шаге от попеды, пробуем заблокировать ему ход

        // Горизонталь
        for (int i = x - 2; i >= 0; i--) {
            if (FIELD[y - 1][i] == DOT) {
                if (checkHorizontal(y - 1, i, PLAYER_CHAR)) {
                    FIELD[y - 1][i] = COMPUTER_CHAR;
                    return;
                } else {
                    break;
                }
            }
        }
        for (int i = x; i < SIZE; i++) {
            if (FIELD[y - 1][i] == DOT) {
                if (checkHorizontal(y - 1, i, PLAYER_CHAR)) {
                    FIELD[y - 1][i] = COMPUTER_CHAR;
                    return;
                } else {
                    break;
                }
            }
        }

        // Вертикаль
        for (int i = y - 2; i >= 0; i--) {
            if (FIELD[i][x - 1] == DOT) {
                if (checkVertical(i, x - 1, PLAYER_CHAR)) {
                    FIELD[i][x - 1] = COMPUTER_CHAR;
                    return;
                } else {
                    break;
                }
            }
        }
        for (int i = y; i < SIZE; i++) {
            if (FIELD[i][x - 1] == DOT) {
                if (checkVertical(i, x - 1, PLAYER_CHAR)) {
                    FIELD[i][x - 1] = COMPUTER_CHAR;
                    return;
                } else {
                    break;
                }
            }
        }

        // Первая диагональ
        for (int i = y - 2, j = x - 2; i >= 0 && j >= 0; i--, j--) {
            if (FIELD[i][j] == DOT) {
                if (checkDiagonal(i, j, PLAYER_CHAR)) {
                    FIELD[i][j] = COMPUTER_CHAR;
                    return;
                } else {
                    break;
                }
            }
        }
        for (int i = y, j = x; i < SIZE && j < SIZE; i++, j++) {
            if (FIELD[i][j] == DOT) {
                if (checkDiagonal(i, j, PLAYER_CHAR)) {
                    FIELD[i][j] = COMPUTER_CHAR;
                    return;
                } else {
                    break;
                }
            }
        }

        // Вторая диагональ
        for (int i = y - 2, j = x; i >= 0 && j < SIZE; i--, j++) {
            if (FIELD[i][j] == DOT) {
                if (checkDiagonal(i, j, PLAYER_CHAR)) {
                    FIELD[i][j] = COMPUTER_CHAR;
                    return;
                } else {
                    break;
                }
            }
        }
        for (int i = y, j = x - 2; i < SIZE && j >= 0; i++, j--) {
            if (FIELD[i][j] == DOT) {
                if (checkDiagonal(i, j, PLAYER_CHAR)) {
                    FIELD[i][j] = COMPUTER_CHAR;
                    return;
                } else {
                    break;
                }
            }
        }

        // Если выйгрыша нет и блокировать нечего, то делаем бездумный ход
        stupidMove();

    }

    private static boolean checkHorizontal(int y, int x, char currentChar) {
        int curX = TicTakToe.x;

        FIELD[y][x] = currentChar;
        TicTakToe.x = (x + 1);
        if (isWin(currentChar)) {
            return true;
        } else {
            FIELD[y][x] = DOT;
            TicTakToe.x = curX;
            return false;
        }

    }

    private static boolean checkVertical(int y, int x, char currentChar) {
        int curY = TicTakToe.y;

        FIELD[y][x] = currentChar;
        TicTakToe.y = (y + 1);
        if (isWin(currentChar)) {
            return true;
        } else {
            FIELD[y][x] = DOT;
            TicTakToe.y = curY;
            return false;
        }

    }

    private static boolean checkDiagonal(int y, int x, char currentChar) {
        int curX = TicTakToe.x;
        int curY = TicTakToe.y;

        FIELD[y][x] = currentChar;
        TicTakToe.y = (y + 1);
        TicTakToe.x = (x + 1);
        if (isWin(currentChar)) {
            return true;
        } else {
            FIELD[y][x] = DOT;
            TicTakToe.y = curY;
            TicTakToe.x = curX;
            return false;
        }

    }

    private static void playerMove() {
        while (true) {
            System.out.println("Ваш ход. Введите координаты (строка, столбец)");

            boolean correctInputData = true;

            try {
                y = SCANNER.nextInt();
                x = SCANNER.nextInt();
            } catch (InputMismatchException e) {
                SCANNER.nextLine();
                correctInputData = false;
            }

            if (correctInputData && isMoveValid()) {
                FIELD[y - 1][x - 1] = PLAYER_CHAR;
            }
            else {
                printField();
                System.out.println("Некорректный ход");
                continue;
            }
            break;
        }
        printField();
    }

    private static boolean isMoveValid() {
        return x >= 0 && y >= 0 && x <= SIZE && y <= SIZE && FIELD[y - 1][x - 1] == DOT;
    }

}
