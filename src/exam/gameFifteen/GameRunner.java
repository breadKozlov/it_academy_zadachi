package exam.gameFifteen;

public class GameRunner {

    public static final String SAVE = "./database/";//относительный путь для сохранения
    public static final String DATA_BASE_DIRECTORY = "database"; //папка с сейвами в рабочей директории

    public static void main(String[] args) {

        GameProcess gameProcess = new GameProcess();//бизнес логика
        SaveAndLoadFiles saveAndLoadFiles = new SaveAndLoadFiles(SAVE,DATA_BASE_DIRECTORY);//все что связано с файлами
        GameInterface gameInterface = new GameInterface(gameProcess,saveAndLoadFiles);//типа интерфейс
        gameInterface.startDialog();
    }
}
