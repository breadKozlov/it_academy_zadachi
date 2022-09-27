package credit;

public class NaZachetNumThree {

    public static void main(String[] args) {

        int n = (int)(Math.random() * 28801);
        go(n);
    }

    public static void go(int n) {

        int sec = n % 60;
        int overMin = ((n - sec) / 60);
        int min = overMin % 60;
        int hour = (overMin - min) / 60;

        System.out.println();
        System.out.println("Vashe chislo: " + n);
        System.out.println();
        printResult(hour,min,sec);
        System.out.println();
        System.out.println("Udachi!");
    }

    public static void printResult (int hour, int min, int sec) {

        String okHour = okonchanieSlovChas(hour);
        String okMin = okonchanieSlov(min);
        String okSec = okonchanieSlov(sec);

        String h = hour + okHour + ", ";
        if (min == 0 && sec == 0) {
            h = "Rovno: " + hour + okHour;
        }
        String printHour = (hour == 0) ? "Menee chasa ili - " : h;

        String m = min + " minut" + okMin + ", ";
        if (sec == 0) {
            m = min + " minut" + okMin;
        }
        String printMin = (min == 0) ? "" : m;

        String s = sec + " sekund" + okSec;
        String printSec = (sec == 0) ? "" : s;

        System.out.println("Do konca rabochego dnja ostalos:");
        System.out.println();
        if (hour == 0 && min == 0 && sec == 0) {
            System.out.println("Nichego ne ostalos. Pora domoj");
        } else {
            System.out.println(printHour + printMin + printSec);
        }
    }

    public static String okonchanieSlov(int m) {

        int naPadezh;
        String okonchanie;

        if (m < 11 || m > 14) {
            naPadezh = m % 10;
        } else {
            naPadezh = m;
        }

        switch (naPadezh) {
            case 1 -> okonchanie = "a";
            case 2, 3, 4 -> okonchanie = "i";
            default -> okonchanie = "";
        }
        return okonchanie;
    }

    public static String okonchanieSlovChas(int h) {

        String chasov;

        switch (h) {
            case 1 -> chasov = " chas";
            case 2, 3, 4 -> chasov = " chasa";
            default -> chasov = " chasov";
            }

        return chasov;
    }
}
