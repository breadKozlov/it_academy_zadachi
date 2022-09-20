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
        System.out.println("Вы хотите повторить?: (Д/н)");
        String answer = scanner.next();
        String yes = "Д";
        String no = "н";

        if (answer.equals(yes)) {
            proverkaRadiusaGo();
        } else {
            if (answer.equals(no)) {
                System.out.println("До свидания!");
            } else {
                System.out.println("Вы ввели неправильное значение! Пожалуйста, введите еще раз!");
                doYouWant();
            }
        }
    }
}
