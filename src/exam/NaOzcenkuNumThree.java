package exam;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class NaOzcenkuNumThree {

    public static void main(String[] args) {

        System.out.print("Введите размерность массива: ");
        int n = new Scanner(System.in).nextInt();
        System.out.println();

        int[][] array = new int[n][n];
        boolean polZnach = false; //флажок, опред. будет ли след. элемент массива идти со знаком "+" если "true"
        int summaElem = 0;

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {

                if (polZnach) {
                    array[i][j] = new Random().nextInt(1,9);
                } else {
                    array[i][j] = new Random().nextInt(-9,-1);
                }

                if (i == j || i + j == n - 1) {

                    array[i][j] = 0;
                    polZnach = !polZnach;
                }

                if (i == j && i + j == n - 1) {

                    array[i][j] = 0;
                    polZnach = false;
                }

                System.out.print(((array[i][j] >= 0) ? "  " : " ") + array[i][j]);

                summaElem += array[i][j];

            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Сумма всех элементов: " + summaElem);

        double summSredArifm = 0;
        double kolSredArim = 0;

        for (int[] ints : array) {

            for (int anInt : ints) {

                if (anInt > summaElem) {

                    summSredArifm += anInt;
                    kolSredArim++;
                }
            }
        }

        DecimalFormat decimalFormat = new DecimalFormat("##.####");
        String sredneeArifm = decimalFormat.format(summSredArifm / kolSredArim);
        // Находим среднее арифм. и форматируем результат в формат 0.0000

        System.out.println("Среднее арифметическое всех элементов больше " + summaElem + " равно: " + sredneeArifm);
    }
}
