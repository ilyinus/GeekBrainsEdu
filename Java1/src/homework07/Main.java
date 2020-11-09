package homework07;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[5];

        cats[0] = new Cat("Barsik" , (int) (Math.random() * 50));
        cats[1] = new Cat("Murzik" , (int) (Math.random() * 50));
        cats[2] = new Cat("Piratik", (int) (Math.random() * 50));
        cats[3] = new Cat("Knopik" , (int) (Math.random() * 50));
        cats[4] = new Cat("Vaska"  , (int) (Math.random() * 50));

        Plate plate = new Plate(50 + (int) (Math.random() * 50));

        while (true) {

            boolean isAllCatsFull = true;

            for (Cat cat : cats) {
                if (cat.isFull)
                    continue;
                cat.eat(plate);
                cat.info();
                isAllCatsFull &= cat.isFull;
            }

            if (isAllCatsFull)
                break;

            plate.addFood((int) (Math.random() * 20));

        }

    }
}
