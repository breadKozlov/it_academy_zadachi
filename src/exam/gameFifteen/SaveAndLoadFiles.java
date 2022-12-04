package exam.gameFifteen;

import java.io.*;
import java.util.Objects;
import java.util.regex.Pattern;

public class SaveAndLoadFiles {

    private final String save;//относительный путь для сохранения
    private final String directory; //папка с сейвами в рабочей директории
    public SaveAndLoadFiles(String save, String directory) {
        this.save = save;
        this.directory = directory;
    }

    public String[][] readFile(String nameFile) {

        String[][] array = new String[4][4];
        String[] ar = new String[16];
        try(BufferedReader br = new BufferedReader(new FileReader(save + nameFile))){
            String phrase;
            while ((phrase = br.readLine()) != null) {
                Pattern pattern = Pattern.compile(" +");
                String[] out = pattern.split(phrase);
                if (out.length == ar.length) {
                    ar = out;
                } else {
                    System.out.println("Error! Length file incorrect!");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for(int i = 0; i < array.length; i++) {
            int level = 4 * i;
            System.arraycopy(ar, level, array[i], 0, array[i].length);
        }
        System.out.println();
        return array;
    }

    public void saveFile(String[][] array, String nameFile) {

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(save + nameFile))){
            for (String[] strings : array) {
                for (String string : strings) {
                    bw.write(string);
                    bw.write(" ");
                }
            }
            System.out.println();
            System.out.println("Сохранение записано! До свидания!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createDataBaseWithSaves() {

        File dir = new File(directory);
        if (dir.mkdir()) {
            System.out.println(":)"); //можно убрать
        } else System.out.println(".");
    }
    public boolean checkAndReaderFiles() {

        boolean result = true;
        File file = new File(directory);
        if(file.isDirectory() && Objects.requireNonNull(file.listFiles()).length > 0) {

            for (File f: Objects.requireNonNull(file.listFiles())) {

                if (f.isDirectory()) {
                    System.out.println(f.getName() + " \t folder");
                } else {
                    System.out.println(f.getName() + "\t file");
                }
            }
        } else {
            System.out.print("Нет слотов для загрузки сохранений. Создайте новую игру. ");
            System.out.println();
            System.out.println();
            result = false;
        }
        return result;
    }
    public boolean checkInputName(String name) {

        boolean answer = false;
        File file = new File(directory);
        for (File f: Objects.requireNonNull(file.listFiles())) {
            if(f.isFile() && f.getName().equalsIgnoreCase(name)) {
                answer = true;
                break;
            }
        }
        return answer;
    }


}
