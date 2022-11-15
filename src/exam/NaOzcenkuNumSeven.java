package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NaOzcenkuNumSeven {

    public static void main(String[] args) {

        String[] arrayString = {"Hello","hello","how","i","my","name","my","my","alibi","hello"};
        Map<String,Integer> arrayMapString = arrayToMap(arrayString);
        for(Map.Entry<String, Integer> item : arrayMapString.entrySet()) {
            System.out.printf("Значение: \"%s\". Количество вхождений в массив - %d; \n", item.getKey()
                    ,item.getValue());
        }
        System.out.println();

        int[] arrayInt = {1,2,4,4,2,4};
        Integer[] arrInteger = new Integer[arrayInt.length];
        for (int i = 0; i < arrInteger.length; i++) {
            arrInteger[i] = arrayInt[i];
        }
        Map<Integer,Integer> arrayMapInt = arrayToMap(arrInteger);
        for(Map.Entry<Integer, Integer> item : arrayMapInt.entrySet()) {
            System.out.printf("Значение: \"%s\". Количество вхождений в массив - %d; \n", item.getKey()
                    ,item.getValue());
        }
        System.out.println();

        Double[] arrayDouble = {1.2,3.3,3.1,3.0,2.0,1.0,1.1,1.2,3.0,3.0,3.1,3.1};
        for(Map.Entry<Double, Integer> item : arrayToMap(arrayDouble).entrySet()) {
            System.out.printf("Значение: \"%s\". Количество вхождений в массив - %d; \n", item.getKey()
                    ,item.getValue());
        }
        System.out.println();

        Person a = new Person("Pasha",32);
        Person b = new Person("Dasha",4);
        Person c = new Person("Pasha",32);
        Person d = new Person("Irina",56);
        Person e = new Person("Dasha",45);
        Person f = new Person("Pasha",32);
        Person g = new Person("Dasha",4);
        Person h = new Person("Sergey",87);
        Person i = new Person("Irina",56);

        Person [] ar = {a,b,c,d,e,f,g,h,i};
        for(Map.Entry<Person, Integer> item : arrayToMap(ar).entrySet()) {
            System.out.printf("Имя: \"%s\". Возраст, лет: \"%d\". Количество вхождений в массив - %d; \n"
                    , item.getKey().getName(), item.getKey().getAge(), item.getValue());
        }
    }

    public static <K> Map<K, Integer> arrayToMap(K[] ks) {

        Map<K,Integer> mapKa = new HashMap<>();
        mapKa.put(ks[0],1);

        for (int i = 1; i < ks.length; i++) {

            int coincidence = 1;
            if (mapKa.containsKey(ks[i])) {
                coincidence = mapKa.get(ks[i]);
                mapKa.put(ks[i], ++coincidence);
            } else {
                mapKa.put(ks[i],coincidence);
            }
        }
        return mapKa;
    }
}

class Person {

    private final String name;
    private final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

