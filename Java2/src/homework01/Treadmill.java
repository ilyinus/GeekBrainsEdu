package homework01;

public class Treadmill extends Obstacle {

    public Treadmill(int width) {
        super(ObstacleType.RUNNING);
        this.width = width;
        System.out.println("Создано препядствие " + this + ". Длина: " + width);
    }

    @Override
    public String toString() {
        return "Treadmill";
    }
}
