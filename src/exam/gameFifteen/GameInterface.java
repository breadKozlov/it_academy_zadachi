package exam.gameFifteen;

import java.util.Scanner;

public class GameInterface {
    private final GameProcess gameProcess;
    private final SaveAndLoadFiles saveAndLoadFiles;

    public GameInterface(GameProcess gameProcess, SaveAndLoadFiles saveAndLoadFiles) {
        this.gameProcess = gameProcess;
        this.saveAndLoadFiles = saveAndLoadFiles;
    }

    public void startDialog() {

        System.out.print("Добро пожаловать в игру \"Пятнашки\"");
        saveAndLoadFiles.createDataBaseWithSaves();
        boolean flag = false;

        while (!flag) {

            System.out.println("Если вы хотите начать "
                    + "новую игру нажмите \"N\". Если хотите загрузить сохраниение, нажмите \"L\". "
                    + "Для выхода из программы нажмите \"Q\"");
            System.out.print("Ваш выбор: ");
            String nameFile = new Scanner(System.in).nextLine();

            switch (nameFile) {

                case "N" -> {

                    gameProcess.startGame();
                    gameProcessDialog();
                    flag = true;
                }
                case "L" -> {

                    boolean checker = false;
                    while(!checker) {

                        if (saveAndLoadFiles.checkAndReaderFiles()) {
                            System.out.print("Введите название файла для чтения: ");
                            String nameF = new Scanner(System.in).nextLine();

                            //проверка на правильно введенное имя загрузочного сохранения
                            if (saveAndLoadFiles.checkInputName(nameF)) {
                                gameProcess.setPoleString(saveAndLoadFiles.readFile(nameF));
                                gameProcessDialog();
                                flag = true;
                                checker = true;
                            } else {
                                System.out.println("Вы ввели некорректное имя загрузочного файла.");
                            }
                        } else {
                            checker = true;
                        }
                    }
                }
                case "Q" -> {
                    System.out.println("Вы вышли из программы.");
                    flag = true;
                }

                default -> System.out.println("Вы ввели недопустимый символ. Повторите еще раз!");
            }
        }
    }

    public void gameProcessDialog() {

        boolean flag = false;

        while (!flag) {

            System.out.println();

            System.out.print("""
                    Для продолжения игры введите число стоящее рядом с [].\s
                    Для выхода из игры нажмите "q".\s
                    Ваш выбор:\s""");

            String input = new Scanner(System.in).nextLine();

            if (input.equals("q")) {

                saveOrNoDialog(gameProcess.getPoleString());// сохранение игры
                flag = true;
            } else {

                flag = gameProcess.gameProcess(input);
                if (flag) {
                    System.out.println();
                    System.out.println("Урра! Вы победили :) !");
                }
            }
        }
    }
    public void saveOrNoDialog (String[][]array){

        boolean flag = false;

        while (!flag) {

            System.out.println("Вы хотите сохранить текущий прогресс? (Y/n)");
            String answer = new Scanner(System.in).nextLine();
            if (answer.equals("Y")) {

                boolean answer2 = false;

                while (!answer2) {

                    System.out.print("Введите название файла для сохранения: ");
                    String nameFile = new Scanner(System.in).nextLine();

                    if(saveAndLoadFiles.checkInputName(nameFile)) {

                        System.out.println("Такое сохранение уже существует. Хотите его перезаписать? (Y/n)");
                        String answer1 = new Scanner(System.in).nextLine();

                        if (answer1.equals("Y")) {

                            saveAndLoadFiles.saveFile(array,nameFile);
                            answer2 = true;
                        }
                    } else {
                        saveAndLoadFiles.saveFile(array,nameFile);
                        answer2 = true;
                    }
                    flag = true;
                }
            } else if (answer.equals("n")) {
                System.out.println();
                System.out.println("Вы вышли из игры. До свидания!");
                flag = true;
            } else {
                System.out.println("Вы ввели недопустимый символ. Повторите еще раз!");
            }
        }
    }
}