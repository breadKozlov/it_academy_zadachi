package credit;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NaZachetNumEight {

    public static void main(String[] args) {

        System.out.println("Введите строку:");
        String input = new Scanner(System.in).nextLine();

        Pattern pattern = Pattern.compile("[ .,?!]+");
        String[] array = pattern.split(input);

        int maxLength = 1;
        int minLength = input.length();
        String maxWord = null;
        String minWord = null;
        int maxim = 0;
        int minim = 0;

        //находим минимальное и максимальное слова и их длины
        for(int i = 0; i < array.length; i++) {

            if (array[i].length() > maxLength) {
                maxLength = array[i].length();
                maxWord = array[i];
                maxim = i;
            }

            if (array[i].length() <= minLength) {
                minLength = array[i].length();
                minWord = array[i];
                minim = i;
            }
        }

        System.out.println();
        System.out.println("Самое длинное слово в тексте - " + maxWord + ", а самое короткое - " + minWord + ";");
        System.out.println("Заменим первое самое длинное слово с последним самым коротким;");
        System.out.println();

        System.out.println("Исходный текст:");
        System.out.println(input);

        if (maxWord != null && minWord != null) {

            Pattern pattern1 = Pattern.compile("\\b" + maxWord + "\\b");
            Matcher matcher1 = pattern1.matcher(input);

            Pattern pattern2 = Pattern.compile("\\b" + minWord + "\\b");
            Matcher matcher2 = pattern2.matcher(input);

            int a = 0;
            int b = 0;
            int a1 = 0;
            int b1 = 0;

            //находим первое упоминание длинного слова и его расположение в тексте
            if (matcher1.find()) {

                a = matcher1.start();
                b = matcher1.end();
            }

            //находим последнее упоминание короткого слова и его расположение в тексте
            while (matcher2.find()) {

                a1 = matcher2.start();
                b1 = matcher2.end();
            }

            StringBuilder output = new StringBuilder(input);

            //проверяем расположение длинного и короткого слова относительно друг друга в тексте
            if (maxim < minim) {

                output.replace(a1,b1,maxWord);
                output.replace(a,b,minWord);
            } else {

                output.replace(a,b,minWord);
                output.replace(a1,b1,maxWord);
            }

            System.out.println();
            System.out.println("Полученный текст:");
            System.out.println(output);

        } else {

            System.out.println("The params maxWord or minWord is null!");
        }
    }
}
