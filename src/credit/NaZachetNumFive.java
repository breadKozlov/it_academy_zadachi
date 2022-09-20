package credit;

import java.util.Scanner;

public class NaZachetNumFive {

    public static void main(String[] args) {

        System.out.println("Vvedite luboe chislo: ");
        Scanner scanner = new Scanner(System.in);

        int vhodnum = scanner.nextInt();
        int sumDelitelej = 0;

        for  (int i = 2; i < vhodnum; i++) {

            if (vhodnum % i == 0) {
                sumDelitelej++;
                break;
            }
        }

        String ne = (sumDelitelej > 0) ? " ne " : " ";
        System.out.println();
        System.out.println("Chislo " + vhodnum + ne + "prostoe");
        System.out.println();
        System.out.print("Ego chisliteli: 1, " );

        for  (int i = 2; i < vhodnum; i++) {

            if (vhodnum % i == 0) {
                System.out.print(i + ", ");
            }
        }

        System.out.print("a takzhe - " + vhodnum);
        System.out.println();
    }
}
