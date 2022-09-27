package credit;

import java.util.Scanner;

public class NaZachetNumFour {

    public static void main(String[] args) {

        System.out.println("Vvedite kolichestvo boevih mashin: ");
        Scanner scanner = new Scanner(System.in);
        int kolMash = scanner.nextInt();
        System.out.println();

        Go(kolMash);
    }

    public static void Go(int n) {

        int sumChisel = 0;

        for (int i = 1; i < n; i++) {

            if (i > 10) {

                int number = i;
                int predOstat = 0;

                while (number > 10) {

                    int ostatok = number % 10;

                    if (ostatok == 4) {
                        sumChisel++;
                        System.out.print(i + " ");
                        break;
                    }

                    if (predOstat == 3 && ostatok == 1) {
                        sumChisel++;
                        System.out.print(i + " ");
                        break;
                    }

                    predOstat = ostatok;

                    number = (number - predOstat)/10;

                    if (number == 1 && predOstat == 3) {
                        sumChisel++;
                        System.out.print(i + " ");
                        break;
                    }

                    if (number == 4) {
                        sumChisel++;
                        System.out.print(i + " ");
                        break;
                    }
                }
            } else if (i == 4) {

                sumChisel++;
                System.out.print(i + " ");
            }
        }

        System.out.println();
        System.out.println();
        System.out.println("Summa boevih mashin s nomerami 4 ili 13, kotorie nuzhno iskluchit ravna: " + sumChisel);
    }
}
