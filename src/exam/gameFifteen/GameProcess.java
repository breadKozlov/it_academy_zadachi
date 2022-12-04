package exam.gameFifteen;

import java.util.*;

public class GameProcess {

    private String[][] poleString = new String[4][4];

    public static String[][] arraySample = {{"1","2","3","4"},{"5","6","7","8"}
            ,{"9","10","11","12"},{"13","14","15","[]"}};

    public String[][] getPoleString() {
        return poleString;
    }

    public void setPoleString(String[][] poleString) {
        this.poleString = poleString;
        printArray(poleString);
    }

    public void startGame() {

        List<String> listNum = new ArrayList<>();
        Collections.addAll(listNum,"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","[]");
        System.out.println();

        for (int i = 0; i < poleString.length; i++) {

            for (int j = 0; j < poleString[i].length; j++) {
                String randomNum = listNum.get(new Random().nextInt(0,listNum.size()));
                poleString[i][j] = randomNum;
                listNum.remove(randomNum);
            }
        }
        printArray(poleString);
    }

    public boolean gameProcess(String input) {

        boolean flag = false;
        int iInput = -1;
        int jInput = -1;
        int iZero = -1;
        int jZero = -1;
        for (int i = 0; i < poleString.length; i++) {

            //находит расположение введенного числа и пустотки
            for (int j = 0; j < poleString[i].length; j++) {

                if (poleString[i][j].equals(input)) {
                    iInput = i;
                    jInput = j;
                }
                if (poleString[i][j].equals("[]")) {
                    iZero = i;
                    jZero = j;
                }
            }
        }

        // проверка чтобы введенное число стояло около []
        if (iZero == iInput && jZero == jInput + 1 || iZero == iInput && jZero == jInput - 1
                || iZero == iInput + 1 && jZero == jInput || iZero == iInput - 1 && jZero == jInput) {

            String buf = poleString[iZero][jZero];
            poleString[iZero][jZero] = poleString[iInput][jInput];
            poleString[iInput][jInput] = buf;

            System.out.println();
            printArray(poleString);

            if (Arrays.deepEquals(poleString, arraySample)) {
                flag = true;
            }
        } else {
            System.out.println();
            System.out.println("Вы ввели недопустимый символ. Повторите еще раз!");
            System.out.println();
            printArray(poleString);
        }
        return flag;
    }
    public void printArray(String[][] array) {

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
}
