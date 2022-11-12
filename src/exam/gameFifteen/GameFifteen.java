package exam.gameFifteen;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class GameFifteen {

    public static String[][] arraySample = {{"1","2","3","4"},{"5","6","7","8"}
            ,{"9","10","11","12"},{"13","14","15","[]"}};
    public static final String SAVE = "./database/";//относительный путь для сохранения
    public static final String DATA_BASE_DIRECTORY = "database"; //папка с сейвами в рабочей директории

    public static void main(String[] args) {

        //ввод, сохранение, чтение и интерфейс взаимодействия реализованы через сканеры, и повторяющиеся функции,
        //а не через консоль, что конечно же когда-нибудь засрет весь стек. Но для игры, думаю, памяти хватит.

        createDataBaseWithSaves(DATA_BASE_DIRECTORY);
        startDialog();
    }

    public static void createDataBaseWithSaves(String directory) {

        System.out.println("Добро пожаловать в игру \"Пятнашки\". ");
        File dir = new File(directory);
        if (dir.mkdir()) {
            System.out.println("Directory created"); //можно убрать
        }
    }

    public static void startDialog() {

        System.out.println("Если вы хотите начать "
                + "новую игру нажмите \"N\". Если хотите загрузить сохраниение, нажмите \"L\". "
                + "Для выхода из программы нажмите \"Q\"");
        System.out.print("Ваш выбор: ");
        String nameFile = new Scanner(System.in).nextLine();

        switch (nameFile) {

            case "N" -> startGame(createIntArray());
            case "L" -> checkAndReaderFiles(DATA_BASE_DIRECTORY);
            case "Q" -> System.out.println("Вы вышли из программы.");
            default -> {
                System.out.println("Вы ввели недопустимый символ. Повторите еще раз!");
                startDialog();
            }
        }
    }

    public static void checkAndReaderFiles(String name) {

        File file = new File(name);

        if(file.isDirectory() && Objects.requireNonNull(file.listFiles()).length > 0) {

            for (File f: Objects.requireNonNull(file.listFiles())) {

                if (f.isDirectory()) {
                    System.out.println(f.getName() + " \t folder");
                } else {
                    System.out.println(f.getName() + "\t file");
                }
            }
            readFile();
        } else {
            System.out.print("Нет слотов для загрузки сохранений. Создайте новую игру. ");
            System.out.println();
            System.out.println();
            startDialog();
        }
    }

    public static void startGame(int[][] poleGame) {

        String[][] poleString = new String[4][4];
        System.out.println();

        for (int i = 0; i < poleString.length; i++) {

            for (int j = 0; j < poleString[i].length; j++) {

                String buffer = Integer.toString(poleGame[i][j]);// конверт в стринг массив чтобы воткнуть []
                poleString[i][j] = (buffer.equals("16")) ? "[]" : buffer;
                System.out.print(((poleGame[i][j] > 9) ? "" : " ") + poleString[i][j] + "  ");
            }
            System.out.println();
        }
        gameProcess(poleString);
    }

    public static int[][] createIntArray() {

        int[][] poleGame = new int[4][4];

        for (int i = 0; i < poleGame.length; i++) {

            for (int j = 0; j < poleGame[i].length; j++) {

                boolean sovp = false;
                int num = 0;

                while (!sovp) {
                    num = new Random().nextInt(1, 17); //рандомит число пока не заполнит весь массив
                    // уникальными от 1 до 16. Наверное не самый эффективный способ заполнения массива
                    sovp = proverkaNaSovp(num, poleGame);//проверка на уникальность в массиве
                }
                poleGame[i][j] = num;
            }
        }
        return poleGame;
    }

    public static boolean proverkaNaSovp(int ob, int[][] array) {

        boolean a = false;
        int o = 0;

        for (int[] init : array) {
            for (int in : init) {
                if (in == ob) {
                    o++;
                }
            }
        }
        if (o == 0) {
            a = true;
        }
        return a;
    }

    public static void saveFile(String[][] array) {

        System.out.print("Введите название файла для сохранения: ");
        String nameFile = new Scanner(System.in).nextLine();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(SAVE + nameFile))){

            for (String[] strings : array) {

                for (String string : strings) {

                    bw.write(string);
                    bw.write(" ");
                }
            }
            System.out.println();
            System.out.println("Сохранение записано! До свидания!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void readFile() {

        System.out.print("Введите название файла для чтения: ");
        String nameFile = new Scanner(System.in).nextLine();
        String[][] array = new String[4][4];
        String[] ar = new String[16];
        try(BufferedReader br = new BufferedReader(new FileReader(SAVE + nameFile))){

            String phrase;

            while ((phrase = br.readLine()) != null) {

                Pattern pattern = Pattern.compile(" +");
                String[] out = pattern.split(phrase);
                if (out.length == ar.length) {
                    ar = out;
                } else {
                    System.out.println("Error! Length file incorrect!");
                }

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for(int i = 0; i < array.length; i++) {

            int level = 4 * i;

            for(int j = 0; j < array[i].length; j++) {

                array[i][j] = ar[level + j];
            }
        }

        System.out.println();
        printArray(array);
        gameProcess(array);
    }
    public static void gameProcess(String[][] array) {

        System.out.println();
        System.out.print("""
                Для продолжения игры введите число стоящее рядом с [].\s
                Для выхода из игры нажмите "q".\s
                Ваш выбор:\s""");

        String input = new Scanner(System.in).nextLine();

        if (input.equals("q")) {
            saveOrNo(array);// сохранение игры
        } else {
            int iInput = -1;
            int jInput = -1;
            int iZero = -1;
            int jZero = -1;
            for (int i = 0; i < array.length; i++) {

                //находит расположение введенного числа и пустотки
                for (int j = 0; j < array[i].length; j++) {

                    if (array[i][j].equals(input)) {
                        iInput = i;
                        jInput = j;
                    }
                    if (array[i][j].equals("[]")) {
                        iZero = i;
                        jZero = j;
                    }
                }
            }

            // проверка чтобы введенное число стояло около []
            if (iZero == iInput && jZero == jInput + 1 || iZero == iInput && jZero == jInput - 1
                    || iZero == iInput + 1 && jZero == jInput || iZero == iInput - 1 && jZero == jInput) {

                String buf = array[iZero][jZero];
                array[iZero][jZero] = array[iInput][jInput];
                array[iInput][jInput] = buf;

                System.out.println();
                printArray(array);

                if (Arrays.deepEquals(array, arraySample)) {
                    System.out.println();
                    System.out.println("Урра! Вы победили :) !");
                } else {
                    gameProcess(array);
                }
            } else {
                System.out.println();
                System.out.println("Вы ввели недопустимый символ. Повторите еще раз!");
                System.out.println();
                printArray(array);
                gameProcess(array);
            }
        }
    }
    public static void printArray(String[][] array) {

        for (String[] strings : array) {

            for (String string : strings) {

                String space = "";

                if (string.equals("[]")) {
                    space = "";
                } else if (Integer.parseInt(string) < 10) {
                    space = " ";
                }
                System.out.print(space + string + "  ");
            }
            System.out.println();
        }
    }

    public static void saveOrNo(String[][] array) {

        System.out.println("Вы хотите сохранить текущий прогресс? (Y/n)");
        String answer = new Scanner(System.in).nextLine();

        if (answer.equals("Y")) {
            saveFile(array);
        } else if (answer.equals("n")) {
            System.out.println();
            System.out.println("Вы вышли из игры. До свидания!");
        } else {
            System.out.println("Вы ввели недопустимый символ. Повторите еще раз!");
            saveOrNo(array);
        }
    }
}
