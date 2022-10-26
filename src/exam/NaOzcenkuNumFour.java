package exam;

import java.util.Scanner;
import java.util.regex.Pattern;

public class NaOzcenkuNumFour {

    public static void main(String[] args) {

        System.out.println("Введите вашу фразу:");
        String input = new Scanner(System.in).nextLine();

        String inputNoSpaceAndUpper = input.strip().toLowerCase();
        Pattern pattern = Pattern.compile("[ ,.?!]+");
        String[] array = pattern.split(inputNoSpaceAndUpper);

        //proverka na pustoj vvod i vvod odnih znakov prepinanija
        int unique = (array.length == 1 && array[0].equals("") || array.length == 0) ? 0 : 1;

        for (int i = 0; i < array.length - 1; i++) {

            boolean coincidence = false;

            for (int j = i + 1; j < array.length; j++) {

                if (array[i].equals(array[j]) || array[i].equals("")) {
                    coincidence = true;
                    break;
                }
            }

            if (!coincidence) {
                unique++;
            }
        }

        System.out.println("Количество уникальных слов будет - " + unique);
    }
}
