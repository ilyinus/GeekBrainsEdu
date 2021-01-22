package homework01;

public class Wall extends Obstacle {

    public Wall(int height) {
        this.height = height;
        System.out.println("Создано препядствие " + this + ". Высота: " + height);
    }

    @Override
    public String toString() {
        return "Wall";
    }

    @Override
    public boolean pass(Action unit) {
        return unit.jump(height);
    }
}
