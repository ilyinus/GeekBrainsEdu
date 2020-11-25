package homework01;

public class Main {

    public static void main(String[] args) {

        Action[] units = new Action[3];
        Obstacle[] obstacles = new Obstacle[10];

        units[0] = new Human();
        units[1] = new Cat();
        units[2] = new Robot();

        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i] = new Treadmill((int) (Math.random() * 21) + 1);
            obstacles[++i] = new Wall((int) (Math.random() * 16) + 1);
        }

        System.out.println();

        for (Action unit : units) {
            for (Obstacle obstacle : obstacles) {
                boolean result = false;
                if (obstacle.getType() == ObstacleType.JUMPING)
                    result = unit.jump(obstacle);
                else if (obstacle.getType() == ObstacleType.RUNNING)
                    result = unit.run(obstacle);
                if (!result)
                    break;
            }
        }

    }
}
