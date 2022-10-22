package credit;

import java.util.Scanner;

public class NaZachetNumNine {

    public static void main(String[] args) {

        Holodilnik hol = new Holodilnik("LG",1500,true,180.6);
        Holodilnik hol1 = new Holodilnik("Samsung",2600,250.9);
        MicroWave micro = new MicroWave("Panasonic",1000,111);
        MicroWave micro1 = new MicroWave("LG",800,80.4);
        MicroWave micro2 = new MicroWave("Horizont",870,true,148.3);
        StiralnajaMashina stir = new StiralnajaMashina("Zanussi",1800,94.2);
        StiralnajaMashina stir1 = new StiralnajaMashina("Indezit",2300,true,340);
        Televisor tel = new Televisor("Toshiba",1250,true,358.7);
        Televisor tel1 = new Televisor("Sony",2580,390.2);
        MultiVarka multiVar = new MultiVarka("Electrolux",750,true,68.5);
        MultiVarka multiVar1 = new MultiVarka("Bosh",569,78.7);
        Laptop lap = new Laptop("HP",1250,true,120.6);
        Laptop lap1 = new Laptop("Dell", 1300,150.9);

        HomeAppliances[] homeAppliances = {hol,hol1,micro,micro1,micro2,stir,stir1,tel,tel1,multiVar,multiVar1,lap,lap1};

        //подсчет мощностей всех включенных приборов
        int allPower = 0;

        for (HomeAppliances i: homeAppliances) {

            if (i.isTurnOn()) {
                allPower += i.getPower();
            }
        }

        System.out.println("Сумма всех мощностей приборов, включенных в розетку: " + allPower + "Вт");
        System.out.println();

        bubbleSortToCost(homeAppliances); // сортировка по цене методом пузырька и вывод на экран

        for (HomeAppliances i: homeAppliances) {
            System.out.println(i.getName() + " - " + i.getCost() + "$");
        }

        System.out.println();

        //поиск прибора по заданным мощности и цене
        System.out.print("Введите минимальное значение потребляемой мощности: ");
        int powerFirst = new Scanner(System.in).nextInt();
        System.out.println();
        System.out.print("Введите максимальное значение потребляемой мощности: ");
        int powerLast = new Scanner(System.in).nextInt();
        System.out.println();
        System.out.println("Введите диапазон стоимости прибора a и b:");
        System.out.print("a = ");
        double costFirst = new Scanner(System.in).nextDouble();
        System.out.print("b = ");
        double costLast = new Scanner(System.in).nextDouble();
        System.out.println();

        int sovpadenie = 0;

        for (HomeAppliances home: homeAppliances) {

            if (home.getPower() >= powerFirst & home.getPower() <= powerLast
                    & home.getCost() >= costFirst & home.getCost() <= costLast) {
                System.out.print("Меня зовут - " + home.getName() + ". ");
                home.whatAreYouDoing();
                sovpadenie++;
            }
        }

        if (sovpadenie == 0) { System.out.println("Такой прибор не найден."); }
    }

    static <T extends HomeAppliances> void bubbleSortToCost(T[] arr) {
        // на каждым шаге справа будет появляться отсортированный элемент
        for (int i = 0; i < arr.length - 1; i++) {
            // оптимизация алгоритма если элементы уже упорядочены
            boolean noSwaps = true;
            // перемещение самого большого элемента вправо
            for (int j = 0; j < arr.length - i - 1; j++) {
                //если два соседних элемента стоят в неправильом порядке - происходит их перестановка
                if (arr[j].getCost() > arr[j + 1].getCost()) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    // меняем значение если была хотя бы 1 перестановка
                    noSwaps = false;
                }
            }
            // если не было перестановок - выходим из цикла
            if (noSwaps) {
                break;
            }
        }
    }
}

abstract class HomeAppliances {

    private final String name;
    private final int power;
    private boolean turnOn;
    private final double cost;

    public HomeAppliances(String name, int power, boolean turnOn, double cost) {
        this.name = name;
        this.power = power;
        this.turnOn = turnOn;
        this.cost = cost;
    }

    public HomeAppliances(String name, int power, double cost) {
        this.name = name;
        this.power = power;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public boolean isTurnOn() {
        return turnOn;
    }

    public double getCost() {
        return cost;
    }

    abstract void whatAreYouDoing();
}
class Holodilnik extends HomeAppliances{

    public Holodilnik(String name, int power, boolean turnOn, double cost) {
        super(name, power, turnOn, cost);
    }

    public Holodilnik(String name, int power, double cost) {
        super(name, power, cost);
    }

    @Override
    void whatAreYouDoing() {
        System.out.println("Я охлаждаю еду.");

    }
}

class Laptop extends HomeAppliances{

    public Laptop(String name, int power, boolean turnOn, double cost) {
        super(name, power, turnOn, cost);
    }

    public Laptop(String name, int power, double cost) {
        super(name, power, cost);
    }

    @Override
    void whatAreYouDoing() {
        System.out.println("Я для компьютерных игр.");
    }
}

class MicroWave extends HomeAppliances{

    public MicroWave(String name, int power, double cost) {
        super(name, power, cost);
    }

    public MicroWave(String name, int power, boolean turnOn, double cost) {
        super(name, power, turnOn, cost);
    }

    @Override
    void whatAreYouDoing() {
        System.out.println("Я нагреваю еду.");
    }
}

class MultiVarka extends HomeAppliances {

    public MultiVarka(String name, int power, boolean turnOn, double cost) {
        super(name, power, turnOn, cost);
    }

    public MultiVarka(String name, int power, double cost) {
        super(name, power, cost);
    }

    @Override
    void whatAreYouDoing() {
        System.out.println("Я варю кашу.");
    }
}

class StiralnajaMashina extends HomeAppliances{

    public StiralnajaMashina(String name, int power, boolean turnOn, double cost) {
        super(name, power, turnOn, cost);
    }

    public StiralnajaMashina(String name, int power, double cost) {
        super(name, power, cost);
    }

    @Override
    void whatAreYouDoing() {
        System.out.println("Я стираю одежду.");
    }
}

class Televisor extends HomeAppliances {

    public Televisor(String name, int power, boolean turnOn, double cost) {
        super(name, power, turnOn, cost);
    }

    public Televisor(String name, int power, double cost) {
        super(name, power, cost);
    }

    @Override
    void whatAreYouDoing() {
        System.out.println("Я показываю передачи.");
    }
}







