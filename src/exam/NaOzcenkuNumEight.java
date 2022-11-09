package exam;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class NaOzcenkuNumEight {

    public static final String FILE_ONE = "in1.txt";
    public static final String FILE_TWO = "in2.txt";
    public static final String FILE_OUT = "out.txt";
    public static NaOzcenkuNumEight runner = new NaOzcenkuNumEight();
    public static int capacity = 1000; //количество значений в файлах
    public static int origin = 1; //начальное для рандома
    public static int bound = 100000; //конечное для рандома
    public static int s = 0;

    public static void main(String[] args) {

        runner.goWork(capacity,origin,bound,FILE_ONE,FILE_TWO,FILE_OUT);
    }

    public void goWork(int capacity,int origin,int bound,String fileOne,String fileTwo,String fileOut) {

        //записывает в String, чтобы можно было прочитать файлы блокнотом
        runner.writeToStringFile(runner.createArraysWithNum(capacity,origin,bound),fileOne);
        runner.writeToStringFile(runner.createArraysWithNum(capacity,origin,bound),fileTwo);

        List<Integer> list = runner.readStringAndConvertToIntArray(fileOne);
        List<Integer> list1 = runner.readStringAndConvertToIntArray(fileTwo);

        System.out.println();
        System.out.println("Merging two int arrays:");
        list.addAll(list1);

        for(Integer a: list) {
            System.out.print(a + " ");
        }
        System.out.println();

        System.out.println("Sort arrays and convert to String: ");
        Collections.sort(list);
        List<String> listString = new LinkedList<>();
        for(Integer a: list) {
            System.out.print(a + " ");
            listString.add(Integer.toString(a));
        }
        System.out.println();
        runner.writeToStringFile(listString,fileOut);
        List<Integer> list2 = runner.readStringAndConvertToIntArray(fileOut);
        System.out.println("The program`s result:" );
        for(Integer a: list2) {
            System.out.print(a + " ");
        }
    }

    public List<Integer> readStringAndConvertToIntArray(String fileName){

        List<Integer> list = new LinkedList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            Pattern pattern = Pattern.compile("[ ]+");
            String phrase;

            while ((phrase = br.readLine()) != null) {

                String[] arrayString = pattern.split(phrase);

                for(String s: arrayString) {
                    list.add(Integer.valueOf(s));
                }
            }
            File file = new File(fileName);
            System.out.println("Reading from file " + file.getPath() + " and converting successfully!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public void writeToStringFile(List<String> list,String fileName) {

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            int writer = 0;

            for(String l: list) {

                bw.write(l);
                writer++;

                //ряды по 15 значений в файле
                if (writer == 15) {
                    bw.write(" \n");
                    writer = 0;
                } else {
                    bw.write(" ");
                }
            }
            bw.flush();
            File file = new File(fileName);
            System.out.println("Write text data to " + file.getPath() + " successfully!");
            System.out.println();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<String> createArraysWithNum(int capacity,int origin,int bound) {

        s++;
        String numOfArray = (s > 1) ? "second" : "first"; //работает только для двух вызовов метода. Если вызовов будет
        // больше - переписать
        System.out.println("Create the " + numOfArray + " array:");
        List<String> list = new LinkedList<>();

        for (int i = 0; i < capacity; i++) {list.add(Integer.toString(new Random().nextInt(origin,bound)));}

        for(String a: list) {System.out.print(a + " ");}

        System.out.println();
        return list;
    }
}
