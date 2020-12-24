package homework01.task3;

import java.util.ArrayList;
import java.util.Iterator;

public class Box<T extends Fruit> implements Comparable<Box<?>> {
    private ArrayList<T> list;
    private String content;

    public Box(String content) {
        list = new ArrayList<>();
        this.content = content;
    }

    public void put(T fruit) {
        list.add(fruit);
    }

    public float getWeight() {
        float result = 0f;

        for (T fruit : list) {
            result += fruit.getWeight();
        }

        return result;

    }

    public boolean compare(Box<?> box) {
        return Math.abs(getWeight() - box.getWeight()) < 0.0001;
    }

    @Override
    public int compareTo(Box<?> box) {
        int result = 0;
        float weight = box.getWeight();

        if ((getWeight() - weight) > 0.0001)
            result = 1;
        else if (((getWeight() - weight) < -0.0001))
            result = -1;

        return result;

    }

    public void pourOver(Box<T> box) {
        Iterator<T> iterator = list.iterator();

        while (iterator.hasNext()) {
            T fruit = iterator.next();
            box.put(fruit);
            iterator.remove();
        }

    }

    @Override
    public String toString() {
        return "Box{" +
                "content='" + content + '\'' +
                '}';
    }
}
