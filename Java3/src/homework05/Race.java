package homework05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Race {
    private Lock lock = new ReentrantLock();
    private boolean isWinnerExist;

    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public void setWinner(String name) {
        lock.lock();
        if (!isWinnerExist) {
            System.out.println(name + " - WIN");
            isWinnerExist = true;
        }
        lock.unlock();
    }

}
