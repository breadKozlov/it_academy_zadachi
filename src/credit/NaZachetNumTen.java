package credit;

import java.util.ArrayDeque;

public class NaZachetNumTen {

    public static void main(String[] args) {

        MyClassDeque myClass = new MyClassDeque();

        myClass.push(3);
        myClass.push(6);
        myClass.push(12);
        myClass.push(21);
        myClass.push(5);
        myClass.push(14);
        myClass.push(45);
        myClass.push(46);

        System.out.print("Стек получился следующий - ");
        for (Integer a: myClass) {
            System.out.print(a.toString() + "; ");
        }
        System.out.println();
        System.out.println("Максимальное значение его будет - " + myClass.max());

        System.out.println("Удаляем вершину");
        myClass.pop();
        System.out.println("Теперь максимальное значение будет - " + myClass.max());

        System.out.println("Еще два раза удаляем вершину");
        myClass.pop();
        System.out.println("Последнее удаляемое значение равно - " + myClass.pop());

        System.out.print("Теперь стек получается следующий - ");
        for (Integer a: myClass) {
            System.out.print(a.toString() + "; ");
        }
        System.out.println();
        System.out.println("Максимальное значение его будет - " + myClass.max());

        System.out.println("Добавим еще три значения");

        myClass.push(67);
        myClass.push(11);
        myClass.push(34);

        System.out.print("И конечный стек получится следующий - ");

        for (Integer a: myClass) {
            System.out.print(a.toString() + "; ");
        }

        System.out.println();
        System.out.println("Максимальное значение которого в итоге - " + myClass.max());

    }
}

class MyClassDeque extends ArrayDeque<Integer> {

    ArrayDeque <Integer> withMax;

    public MyClassDeque() {
        withMax = new ArrayDeque<>(); //создаем еще один стек для хранения максимального значения
    }

    public void push(int value) {
        if (value >= max()) {
            withMax.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == max()) { //если удаляемое значение совпадает с максимумом удаляем и максимум со стека
            withMax.pop();
        }
        return value;
    }

    public int max() {
        if (withMax.isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            return withMax.peek();
        }
    }
}
