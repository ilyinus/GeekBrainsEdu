package homework01;

public class Wall extends Obstacle {

    public Wall(int height) {
        super(ObstacleType.JUMPING);
        this.height = height;
        System.out.println("Создано препядствие " + this + ". Высота: " + height);
    }

    @Override
    public String toString() {
        return "Wall";
    }
}
