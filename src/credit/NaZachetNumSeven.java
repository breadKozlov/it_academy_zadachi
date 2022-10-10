package credit;

import java.util.Random;
import java.util.Scanner;

public class NaZachetNumSeven {

    public static void main(String[] args) {

        System.out.print("Введите размерность массива: ");

        int[] array = new int[new Scanner(System.in).nextInt()];

        for (int i = 0; i < array.length; i++) {

            array[i] = new Random().nextInt(-100,100);
            System.out.print(array[i] + " ");
        }

        System.out.println();

        for (int i = 0, buffer; i < (array.length) / 2; i++) {

            buffer = array[i];
            array[i] = array[(array.length - 1) - i];
            array[(array.length - 1) - i] = buffer;

        }

        for (int j: array) {
            System.out.print(j + " ");
        }

    }
}
