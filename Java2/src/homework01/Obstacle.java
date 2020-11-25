package homework01;

public abstract class Obstacle {
    protected int height;
    protected int width;
    protected ObstacleType type;

    public Obstacle(ObstacleType type) {
        this.type = type;
    }

    public ObstacleType getType() {
        return type;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
