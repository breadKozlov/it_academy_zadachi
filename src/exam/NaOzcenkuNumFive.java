package exam;

public class NaOzcenkuNumFive {

        public static void main(String[] args) {

            Cvetok cvetok = new Tsulpan("красный", 3.5, 5);
            Cvetok cvetok1 = new Tsulpan(4, 5);
            Cvetok cvetok2 = new Rosa("белый", 4.7, 5);
            Cvetok cvetok3 = new Lilija("желтый", 3, 3);
            Cvetok cvetok4 = new Lilija(3, 3);
            Cvetok cvetok5 = new Gvozdika("синий", 2.1, 4);
            Cvetok cvetok6 = new Gvozdika(2, 4);
            Cvetok cvetok7 = new Astra("оранжевый", 1.5, 6);
            Cvetok cvetok8 = new Astra(1.6, 8);

            Cvetok[] buket = {cvetok, cvetok1, cvetok2, cvetok3, cvetok4, cvetok5, cvetok6, cvetok7, cvetok8};

            System.out.println("Общее количество цветов в букете: " + buket.length + " шт.");

            int cost = 0;

            for(Cvetok c: buket) {
                cost += c.getCost();
            }

            System.out.println("Стоимость букета: " + cost + "$");
            System.out.print("Букет содержит в себе следующие цвета: ");

            //проверка на уникальность цветов в букете
            for (int i = 0; i < buket.length - 1; i++) {

                boolean coincidence = false;

                for (int j = i + 1; j < buket.length; j++) {

                    if (buket[i].getColor().equals(buket[j].getColor())) {
                        coincidence = true;
                        break;
                    }
                }

                if (!coincidence) {
                    System.out.print(buket[i].getColor() + ", ");
                }
            }

            System.out.print("и " + buket[buket.length - 1].getColor() + ".\n");

            int maxLifeCycle = 0;

            for (Cvetok buk: buket) {

                if (buk.getLifeTime() > maxLifeCycle) {
                    maxLifeCycle = buk.getLifeTime();
                }
            }

            System.out.println("Букет польностью завянет через " + maxLifeCycle + " дней.");
        }
    }

    abstract class Cvetok {

        private final String name;
        private final String color;
        private final double cost;
        private final int lifeTime;

        public Cvetok(String name, String color, double cost, int lifeTime) {
            this.name = name;
            this.color = color;
            this.cost = cost;
            this.lifeTime = lifeTime;
        }

        public String getName() {
            return name;
        }

        public String getColor() {
            return color;
        }

        public double getCost() {
            return cost;
        }

        public int getLifeTime() {
            return lifeTime;
        }
    }

    class Tsulpan extends Cvetok {
        public Tsulpan(String name, String color, double cost, int lifeTime) {
            super(name, color, cost, lifeTime);
        }

        public Tsulpan(String color, double cost, int lifeTime) {
            this("Тюльпан", color, cost, lifeTime);
        }

        public Tsulpan(double cost, int lifeTime) {
            this("Тюльпан", "желтый", cost, lifeTime);
        }
    }

    class Rosa extends Cvetok {
        public Rosa(String name, String color, double cost, int lifeTime) {
            super(name, color, cost, lifeTime);
        }

        public Rosa(String color, double cost, int lifeTime) {
            this("Роза", color, cost, lifeTime);
        }

        public Rosa(double cost, int lifeTime) {
            this("Роза", "розовый", cost, lifeTime);
        }
    }

    class Gvozdika extends Cvetok {
        public Gvozdika(String name, String color, double cost, int lifeTime) {
            super(name, color, cost, lifeTime);
        }

        public Gvozdika(String color, double cost, int lifeTime) {
            this("Гвоздика", color, cost, lifeTime);
        }

        public Gvozdika(double cost, int lifeTime) {
            this("Гвоздика", "красный", cost, lifeTime);
        }
    }

    class Lilija extends Cvetok {
        public Lilija(String name, String color, double cost, int lifeTime) {
            super(name, color, cost, lifeTime);
        }

        public Lilija(String color, double cost, int lifeTime) {
            this("Лилия", color, cost, lifeTime);
        }

        public Lilija(double cost, int lifeTime) {
            this("Лилия", "белый", cost, lifeTime);
        }
    }

    class Astra extends Cvetok {
        public Astra(String name, String color, double cost, int lifeTime) {
            super(name, color, cost, lifeTime);
        }

        public Astra(String color, double cost, int lifeTime) {
            this("Астра", color, cost, lifeTime);
        }

        public Astra(double cost, int lifeTime) {
            this("Астра", "фиолетовый", cost, lifeTime);
        }
}
