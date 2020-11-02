package homework06;

public abstract class Animal {

    private String name;
    protected int runLimit;
    protected float jumpLimit;
    protected int swimLimit;

    public Animal(String name) {
        this.name = name;
    }

    public void run(int value) {
        if (value <= runLimit)
            System.out.println("Животное " + name + " легко пробежало " + value + " метров");
        else
            System.out.println("Животное " + name + " недостаточно подготовлено пробежать " + value + " метров");
    }

    public void jump(float value) {
        if (value <= jumpLimit)
            System.out.println("Животное " + name + " легко перепрыгнуло " + value + " метров");
        else
            System.out.println("Животное " + name + " недостаточно подготовлено перепрыгнуть " + value + " метров");
    }

    public void swim(int value) {
        if (value <= jumpLimit)
            System.out.println("Животное " + name + " легко прплыло " + value + " метров");
        else
            System.out.println("Животное " + name + " недостаточно подготовлено переплыть " + value + " метров");
    }

}
