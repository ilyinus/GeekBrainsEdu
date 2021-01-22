package homework01;

public class Treadmill extends Obstacle {

    public Treadmill(int width) {
        this.width = width;
        System.out.println("Создано препядствие " + this + ". Длина: " + width);
    }

    @Override
    public String toString() {
        return "Treadmill";
    }

    @Override
    public boolean pass(Action unit) {
        return unit.run(width);
    }
}
