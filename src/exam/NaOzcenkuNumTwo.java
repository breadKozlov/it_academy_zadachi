package exam;

import java.util.Scanner;
public class NaOzcenkuNumTwo {

    public static void main(String[] args) {

        System.out.println("Введите число а: ");
        int a = new Scanner(System.in).nextInt();

        System.out.println("Введите число b: ");
        int b = new Scanner(System.in).nextInt();

        System.out.println("Введите число h: ");
        int h = new Scanner(System.in).nextInt();

        if (a <= b && a < h) {
            System.out.println("Это невозможно!");
        } else {

            int l = 0;

            for (int i = 1; i <= h; i++) {

                l += a;

                if (l >= h) {
                    System.out.println("Количество дней: " + i);
                    break;
                }

                l -= b;
            }
        }
    }
}
