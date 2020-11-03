package homework07;

public class Cat {
    private String name;
    private int appetite;
    boolean isFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isFull = false;
        System.out.println("У кота " + name + " аппетит " + appetite);
    }

    public void eat(Plate p) {
        isFull = p.decreaseFood(appetite);
    }

    public boolean isFull() {
        return isFull;
    }

    public void info() {
        System.out.println(isFull ? "Кот " + name + " сыт" : "Кот " + name + " все еще голоден");
    }

}
