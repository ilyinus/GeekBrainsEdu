package homework01;

public class Cat implements Action {
    private final static int MAX_JUMP = 10;
    private final static int MAX_RUN = 15;
    private final static String UNIT_KIND = "Кот";

    @Override
    public boolean jump(int height) {
        if (height <= MAX_JUMP) {
            System.out.println(UNIT_KIND + " перепрыгнул препядствие высотой " + height);
            return true;
        } else {
            System.out.println(UNIT_KIND + " не смог перепрыгнуть препядствие высотой " + height);
            return false;
        }
    }

    @Override
    public boolean run(int width) {
        if (width <= MAX_RUN) {
            System.out.println(UNIT_KIND + " пробежал препядствие длиной " + width);
            return true;
        } else {
            System.out.println(UNIT_KIND +" не смог пробежать препядствие длиной " + width);
            return false;
        }
    }
}
