package homework01;

public class Robot implements Action {
    private final static int MAX_JUMP = 15;
    private final static int MAX_RUN = 20;
    private final static String UNIT_KIND = "Робот";

    @Override
    public boolean jump(Obstacle obstacle) {
        if (obstacle.getHeight() <= MAX_JUMP) {
            System.out.println(UNIT_KIND + " перепрыгнул препядствие " + obstacle + " высотой " + obstacle.getHeight());
            return true;
        } else {
            System.out.println(UNIT_KIND + " не смог перепрыгнуть препядствие " + obstacle + " высотой " + obstacle.getHeight());
            return false;
        }
    }

    @Override
    public boolean run(Obstacle obstacle) {
        if (obstacle.getWidth() <= MAX_RUN) {
            System.out.println(UNIT_KIND + " пробежал препядствие " + obstacle + " длиной " + obstacle.getWidth());
            return true;
        } else {
            System.out.println(UNIT_KIND +" не смог пробежать препядствие " + obstacle + " длиной " + obstacle.getWidth());
            return false;
        }
    }
}
