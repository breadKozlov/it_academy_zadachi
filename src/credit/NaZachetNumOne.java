package credit;

import java.util.Scanner;

public class NaZachetNumOne {

    public static void main (String [] args) {
        proverkaRadiusaGo();
    }

    public static void proverkaRadiusaGo() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите а: ");
        double a = scanner.nextDouble();
        System.out.println("Введите b: ");
        double b = scanner.nextDouble();
        System.out.println("Введите r: ");
        int r = scanner.nextInt();

        int c = (int) (Math.sqrt(a*a + b*b))/2;

        if (r >= c) {
            System.out.println("Данное отверстие можно закрыть картонкой.");
        } else {
            System.out.println("Данное отверстие нельзя закрыть картонкой.");
        }
        doYouWant();
    }


    public static void doYouWant() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want retry?: (Y/n)");
        String answer = scanner.next();
        String yes = "Y";
        String no = "n";

        if (answer.equals(yes)) {
            proverkaRadiusaGo();
        } else {
            if (answer.equals(no)) {
                System.out.println("Good bye!");
            } else {
                System.out.println("You entered the wrong letter! Retry the enter!");
                doYouWant();
            }
        }
    }
}
