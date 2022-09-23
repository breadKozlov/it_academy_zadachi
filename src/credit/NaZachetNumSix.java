package credit;

import java.util.Scanner;
import java.util.Random;

public class NaZachetNumSix {
    public static void main(String[] args) {

        System.out.print("Введите размер массива: ");

        int[] array = new int[new Scanner(System.in).nextInt()];

        System.out.println();
        System.out.print("Ваш массив будет следующий: ");

        for (int i = 0; i < array.length; i++) {

            array[i] = new Random().nextInt(100);
            System.out.print(array[i] + " ");
        }

        System.out.println();
        System.out.println();

        int maxNum = 0;
        int maxNumIndex = 0;

        for (int i = 0; i < array.length; i++) {

            maxNumIndex = (array[i] >= maxNum) ? i : maxNumIndex;
            maxNum = Math.max(array[i], maxNum);
        }

        int minNum = maxNum;
        int minNumIndex = 0;

        for (int i = 0; i < array.length; i++) {

            minNumIndex = (array[i] <= minNum) ? i : minNumIndex;
            minNum = Math.min(array[i], minNum);
        }

        System.out.println("Индекс максимального элемента: " + maxNumIndex);
        System.out.println("Индекс минимального элемента " + minNumIndex);
    }
}
