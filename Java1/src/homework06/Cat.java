package homework06;

public class Cat extends Animal {

    public Cat() {
        super("безымянный кот");
        this.runLimit = 200;
        this.jumpLimit = 2;
    }

    public Cat(String name, int runLimit, float jumpLimit) {
        super(name);
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    @Override
    public void swim(int value) {
        System.out.println("Коты не умеют плавать");
    }
}
