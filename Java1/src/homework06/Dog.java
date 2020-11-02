package homework06;

public class Dog extends Animal {

    public Dog() {
        super("безэмянный пес");
        this.runLimit = 500;
        this.jumpLimit = 0.5f;
        this.swimLimit = 10;
    }

    public Dog(String name, int runLimit, float jumpLimit, int swimLimit) {
        super(name);
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.swimLimit = swimLimit;
    }

}
