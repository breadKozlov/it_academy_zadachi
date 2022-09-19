package credit;

import java.util.Scanner;

public class NaZachetNumTwo {

    public static void main(String[] args) {

        vvodDaty();
    }

    public static void vvodDaty() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of the day:");
        int dayNum = scanner.nextInt();
        System.out.println("Enter the number of the moth:");
        int mothNum = scanner.nextInt();
        System.out.println("Enter the number of the year:");
        int yearNum = scanner.nextInt();

        int nextDay;
        int nextMoth = mothNum;

        boolean visocYear = yearNum % 4 == 0;

        switch (mothNum) {
            case 2 -> {
                if(dayNum == 28 && visocYear) {
                    nextDay = dayNum + 1;
                } else if(dayNum == 29||dayNum == 28) {
                    nextDay = 1;
                    nextMoth = mothNum + 1;
                } else {
                    nextDay = dayNum + 1;
                }
                printResult(nextDay,nextMoth,yearNum);
            }
            case 4, 6, 9, 11 -> {
                if (dayNum == 30) {
                    nextDay = 1;
                    nextMoth = mothNum + 1;
                } else {
                    nextDay = dayNum + 1;
                }
                printResult(nextDay,nextMoth,yearNum);
            }
            case 12 -> {
                if (dayNum == 31) {
                    nextDay = 1;
                    nextMoth = 1;
                    yearNum += 1;
                } else {
                    nextDay = dayNum + 1;
                }
                printResult(nextDay,nextMoth,yearNum);
            }
            default -> {
                if (dayNum == 31) {
                    nextDay = 1;
                    nextMoth = mothNum + 1;
                } else {
                    nextDay = dayNum + 1;
                }
                printResult(nextDay,nextMoth,yearNum);
            }
        }
        doYouWantAgain();
    }

    public static void doYouWantAgain() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want retry?: (Y/n)");
        String answer = scanner.next();
        String yes = "Y";
        String no = "n";

        if (answer.equals(yes)) {
            System.out.println();
            vvodDaty();
        } else {
            if (answer.equals(no)) {
                System.out.println("Good bye!");
            } else {
                System.out.println("You entered the wrong letter! Retry the enter!");
                System.out.println();
                doYouWantAgain();
            }
        }
    }

    public static void printResult(int a, int b, int c) {

        System.out.println("The next date of: " + a + " " + b + " " + c);
        System.out.println();
    }
}
