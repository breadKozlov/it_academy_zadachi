package credit;

public class NaZachetNumThree {

    public static void main(String[] args) {

        int n = (int)(Math.random() * 28801);
        Go(n);
    }

    public static void Go(int n) {

        int sec = n % 60;
        int overMin = ((n - sec) / 60);
        int min = overMin % 60;
        int hour = (overMin - min) / 60;

        String chasov = okonchanieSlovChas(hour);
        String minut = okonchanieSlov(min);
        String secund = okonchanieSlov(sec);

        System.out.println();
        System.out.println("Vashe chislo: " + n);
        System.out.println();
        printResult(hour,min,sec,chasov,minut,secund);
        System.out.println();
        System.out.println("Udachi!");
    }

    public static void printResult (int hour, int min, int sec, String ch, String m, String s) {

        if (hour == 0 && sec == 0 && min == 0) {
            System.out.println("Nichego ne ostalos, pora domoj");
        } else if (hour == 0 && min == 0) {
            System.out.println("Ostalos do konca rabochego dnja: " + ch + sec + " secund" + s);
        } else if (hour == 0 && sec == 0) {
            System.out.println("Ostalos do konca rabochego dnja: " + ch + min + " minut" + m);
        } else if (min == 0 && sec == 0){
            System.out.println("Ostalos do konca rabochego dnja: " + hour + ch);
        } else if (hour == 0) {
            System.out.println("Ostalos do konca rabochego dnja: " + ch + min + " minut" + m + ", " + sec
                    + " secund" + s);
        } else if (min == 0) {
            System.out.println("Ostalos do konca rabochego dnja: " + hour + ch + ", " + sec + " secund" + s);
        } else if (sec == 0) {
            System.out.println("Ostalos do konca rabochego dnja: " + hour + ch + ", " + min + " minut" + m);
        } else {
            System.out.println("Ostalos do konca rabochego dnja: " + hour + ch + ", " + min + " minut" + m + ", "
                    + sec + " secund" + s);
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
            default -> {
                if (h == 0) {
                    chasov = "menee chasa ili - ";
                } else { chasov = " chasov";
                }
            }
        }
        return chasov;
    }
}
