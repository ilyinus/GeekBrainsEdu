package homework01;

public abstract class Obstacle {
    protected int height;
    protected int width;

  public abstract boolean pass(Action unit);

}
