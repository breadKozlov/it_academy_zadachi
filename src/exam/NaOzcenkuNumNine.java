package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NaOzcenkuNumNine {

    public static void main(String[] args) {

        List<Point> arrayPoints = new ArrayList<>();
        Collections.addAll(arrayPoints,
                new Point(2,3,2), new Point(7,7,2), new Point(1,6,2),
                new Point(1,2,1), new Point(5,2,8), new Point(3,7,0),
                new Point(2,2,8), new Point(0,3,1), new Point(7,6,2),
                new Point(1,2,1), new Point(2,1,7), new Point(3,1,8));

        new NaOzcenkuNumNine().doExam_09(arrayPoints);
    }

    private void doExam_09(List<? extends Point> arrayPoints) {

        Point maxWithX = arrayPoints.stream().max(new PointXComparator()).orElseThrow();
        System.out.println("Наибольшее значение координаты Х у точки: " + maxWithX + "\n");

        System.out.println("Поток расстояний точек до центра координат в формате double:");
        arrayPoints.stream().map(Point::getDistanceToOrigin).forEach(s -> System.out.printf("%.3f\n",s));
        System.out.println();

        System.out.println("""
                Создал новый поток объектов, расстояние от которых до начала координат более 5
                и отсортировал их в порядке убывания по критерию расстояния от точки до начала координат.
                Вывел результат на экран:
                """);
        arrayPoints.stream()
                .filter(s -> s.getDistanceToOrigin() > 5)
                .sorted(new PointDistanceToOriginComparatorMaxToMin())
                .forEach(s -> System.out.printf("%s" + ", и ее расстояние до начала координат: "
                        + "%.3f\n", s, s.getDistanceToOrigin()));
    }
}

class PointXComparator implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {
        return Integer.compare(o1.getX(),o2.getX());
    }
}

class PointDistanceToOriginComparatorMaxToMin implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {
        return Double.compare(o2.getDistanceToOrigin(),o1.getDistanceToOrigin());
    }
}

record Point(int x, int y, int z) {

    public int getX() {
        return x;
    }

    public double getDistanceToOrigin() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public String toString() {
        return "Point {" +
                "x = " + x +
                ", y = " + y +
                ", z = " + z +
                '}';
    }
}

