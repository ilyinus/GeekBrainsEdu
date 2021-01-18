package homework01.task3;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>("Яблоки");
        Box<Apple> emptyAppleBox = new Box<>("Яблоки");

        Box<Orange> orangeBox = new Box<>("Апельсины");
        Box<Orange> emptyOrangeBox = new Box<>("Апельсины");

        ArrayList<Box<?>> boxes = new ArrayList<>();

        boxes.add(appleBox);
        boxes.add(orangeBox);

        for (int i = 0; i < 20; i++) {
            appleBox.put(new Apple((float) (Math.random() * 10)));
            orangeBox.put(new Orange((float) (Math.random() * 10)));
        }

        System.out.println("Вес коробки яблок: " + appleBox.getWeight());
        System.out.println("Вес коробки апельсинов: " + orangeBox.getWeight());
        System.out.println("Веса коробок равны? - " + appleBox.compare(orangeBox));

        Collections.sort(boxes);
        System.out.println(boxes);

        appleBox.pourOver(emptyAppleBox);
        orangeBox.pourOver(emptyOrangeBox);

        System.out.println("Вес \"пустой\" коробки яблок: " + emptyAppleBox.getWeight());
        System.out.println("Вес \"пустой\" коробки апельсинов: " + emptyOrangeBox.getWeight());
        System.out.println("Вес коробки яблок: " + appleBox.getWeight());
        System.out.println("Вес коробки апельсинов: " + orangeBox.getWeight());

    }
}
