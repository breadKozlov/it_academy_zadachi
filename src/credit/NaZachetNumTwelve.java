package credit;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Random;

public class NaZachetNumTwelve {

    public static final String FILE_NUM = "fileWithNum.txt";

    public static void main(String[] args) {

        //вводим длину массива и имя файла для записи(чтения)
        new NaZachetNumTwelve().runner(30,FILE_NUM);
    }

    public void runner(int sizeArray, String fileName) {

        try {
            writeByteArray(createByteArray(sizeArray),fileName); //создание и запись массива
            readPrintAndCountByteArray(fileName); //чтение из файла, вывод на экран и подсчет среднего арифметического
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public byte[] createByteArray(int capacity) {

        byte[] array = new byte[capacity];
        System.out.println("Создаем " + capacity + " случайных чисел от 1 до 100 и выводим их на экран: ");

        for(int i = 0; i < array.length; i++) {
            array[i] = (byte) new Random().nextInt(1,100);
            System.out.print(array[i] + " ");
        }
        System.out.println();
        return array;
    }

    public void writeByteArray(byte[] b, String fileName) throws IOException {

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName))) {

            bos.write(b,0,b.length);
            File file = new File(fileName);
            System.out.println("Файл успешно записан в: " + file.getPath());
        }
        System.out.println();
    }

    public void readPrintAndCountByteArray(String fileName) throws IOException {

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName))) {

            byte[] inArr = bis.readAllBytes();
            File file = new File(fileName);
            System.out.println("Содержимое успешно прочитано из файла: " + file.getPath());
            System.out.println("Вывожу данные и считаю среднее арифметическое: ");

            for (byte b : inArr) {
                System.out.print(b + " ");
            }
            new NaZachetNumTwelve().countAverage(inArr);
        }
    }

    public void countAverage(byte[] a) {

        double sum = 0;
        for(byte x: a) { sum += x; }
        DecimalFormat df = new DecimalFormat("##.##");
        System.out.println();
        System.out.println("Среднее арифметическое значение массива: " + df.format(sum/a.length));
    }
}
