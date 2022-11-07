package credit;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class NaZachetNumEleven {

    public static final String IN_TEXT_FILE = "PracticeText.txt";
    public static void main(String[] args) {

        new NaZachetNumEleven().runner(IN_TEXT_FILE);
    }

    public void runner(String fileName) {

        System.out.print("Введите вашу строку: ");
        String inText = new Scanner(System.in).nextLine();

        StringBuilder a;
        NaZachetNumEleven pract = new NaZachetNumEleven();

        try {
            pract.fileStringWriter(fileName, inText);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            a = pract.fileStringReader(fileName);
            System.out.println("Ваша строка успешно прочитана из файла. Провожу аналитику и вывожу"
                    + " на экран результаты...");
            System.out.println();
            pract.countWordMarks(a);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileStringWriter(String fileName, String inputText) throws IOException {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            bw.write(inputText);
            File file = new File(fileName);
            System.out.println("Файл успешно записан в " + file.getAbsolutePath());
        }
    }

    public StringBuilder fileStringReader(String fileName) throws IOException {

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            File file = new File(fileName);
            System.out.println("Идет чтение из файла по адресу" + file.getAbsolutePath());
            String c;
            while ((c = (br.readLine())) != null ) {

                sb.append(c);
            }
        }
        return sb;
    }

    public void countWordMarks(StringBuilder text) {

        int l = text.length();

        if (l == 0) {
            System.out.println("Ваша строка пустая!");
        } else {
            System.out.println("Ваш текст: \"" + text + "\"");
        }

        Pattern pat = Pattern.compile("[ ,.?!:;]+");

        String[] array = pat.split(text);

        int capacity = 0;
        int sumWords = 0;

        for (String a: array) {

            //на случай если в строке были в начале и(или) в конце пробелы, после сплита будут "". Проверка
            if (!a.equals("")) {

                sumWords += a.length();
                capacity++;
            }
        }

        int numOfZnaki = l - sumWords;

        System.out.println("Общее число знаков в строке: " + l);
        System.out.println("Количество знаков препинания, включая пробелы: " + numOfZnaki);
        System.out.println("Количество полных слов: " + capacity);
        System.out.println("Спасибо за внимание :)");
    }
}
