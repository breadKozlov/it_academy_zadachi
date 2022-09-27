package exam;

import java.util.Scanner;

public class NaOzcenkuNumOne {

    public static void main(String[] args) {

        enterN();
    }

    public static void enterN () {

        System.out.println("Пожалуйста, введите число секунд: ");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Вы ввели 0 или отрицательное значение! Повторите запрос.");
            System.out.println();
            enterN();
        } else {
            go(n);
        }
    }

    public static void go (int n) {

        int sec = n % 60;
        int overMin = ((n - sec) / 60);
        int min = overMin % 60;
        int overHour = (overMin - min) / 60;
        int hour = overHour % 24;
        int overDay = (overHour - hour)/24;
        int day = overDay % 7;
        int week = (overDay - day) / 7;

        printResult(sec,min,hour,day,week);
    }

    public static void printResult(int sec,int min,int hour,int day,int week) {

        String okSec = okonchanieMinSec(sec);
        String okMin = okonchanieMinSec(min);
        String okHour = okonchanieHour(hour);
        String okDay = okonchanieDay(day);
        String okWeek = okonchanieWeek(week);

        String w = week + okWeek + ", ";
        if (day == 0 && hour == 0 && min == 0 && sec == 0) {
            w = week + okWeek;
        }
        String printWeek = (week == 0) ? "" : w;

        String d = day + okDay + ", ";
        if (hour == 0 && min == 0 && sec == 0) {
            d = day + okDay;
        }
        String printDay = (day == 0) ? "" : d;

        String h = hour + okHour + ", ";
        if (min == 0 && sec == 0) {
            h = hour + okHour;
        }
        String printHour = (hour == 0) ? "" : h;

        String m = min + " минут" + okMin + ", ";
        if (sec == 0) {
            m = min + " минут" + okMin;
        }
        String printMin = (min == 0) ? "" : m;

        String s = sec + " секунд" + okSec;
        String printSec = (sec == 0) ? "" : s;

        System.out.println("Конвертирую в нормальный формат...");
        System.out.println();
        System.out.println("Ваше число - это: " + printWeek + printDay
                + printHour + printMin + printSec);

        doYouWantRetry();
    }

    public static String okonchanieMinSec(int m) {

        String okonchanie;

        int naPadezh = (m < 11 || m > 14) ? m % 10 : m;

        switch (naPadezh) {
            case 1 -> okonchanie = "а";
            case 2, 3, 4 -> okonchanie = "ы";
            default -> okonchanie = "";
        }
        return okonchanie;
    }

    public static String okonchanieHour(int h) {

        String okonchanie;

        int naPadezh = (h < 11 || h > 14) ? h % 10 : h;

        switch (naPadezh) {
            case 1 -> okonchanie = " час";
            case 2, 3, 4 -> okonchanie = " часа";
            default -> okonchanie = " часов";
            }
        return okonchanie;
    }

    public static String okonchanieDay(int d) {

        return (d == 1) ? " сутки" : " суток";
    }

    public static String okonchanieWeek(int w) {

        String okonchanie;

        int naPadezh = (w < 11 || w > 14) ? w % 10 : w;

        switch (naPadezh) {
            case 1 -> okonchanie = " неделя";
            case 2, 3, 4 -> okonchanie = " недели";
            default -> {
                if (w == 0) {
                    okonchanie = "";
                } else {
                    okonchanie = " недель";
                }
            }
        }
        return okonchanie;
    }

    public static void doYouWantRetry() {

        System.out.println();
        System.out.println("Хотите повторить запрос?: (Д/н)");

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        String yes = "Д";
        String no = "н";

        if (answer.equals(yes)) {
            System.out.println();
            enterN();
        } else {
            if (answer.equals(no)) {
                System.out.println("Ну нет, так нет. До свидания!");
            } else {
                System.out.println("Вы ввели не ту букву. Повторите выбор!");
                doYouWantRetry();
            }
        }
    }
}



