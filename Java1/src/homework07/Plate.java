package homework07;

public class Plate {
    private int capacity;
    private int food;

    public Plate(int food) {
        capacity = food;
        this.food = food;
        System.out.println("В миску положили " + food + " еды");
    }

    public boolean decreaseFood(int n) {
        boolean result = false;
        if (food >= n) {
            food -= n;
            result = true;
        }
        return result;
    }

    public void addFood(int food) {
        this.food = Math.min(this.food + food, capacity);
        System.out.println("Добавляем еду в миску. Теперь в миске " + this.food + " еды");
    }

    public void info() {
        System.out.println("В миске " + food + " еды");
    }
}
