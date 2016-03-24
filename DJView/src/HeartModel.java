import java.util.ArrayList;
import java.util.Random;

public class HeartModel implements HeartModelInterface, Runnable {
    ArrayList<BeatObserver> beatObservers = new ArrayList<BeatObserver>();
    ArrayList<BPMObserver> bpmObservers = new ArrayList<BPMObserver>();
    int time = 1000;
    int bpm = 90;
    Random random = new Random(System.currentTimeMillis());
    Thread thread;

    public HeartModel() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        int lastrate = -1;

        for(;;) {
            int change = random.nextInt(10);
            if (random.nextInt(2) == 0) {
                change = 0 - change;
            }
            int rate = 60000 / (time + change);
            if (rate < 120 && rate > 50) {
                time += change;
                notifyBeatObservers();
                if (rate != lastrate) {
                    lastrate = rate;
                    notifyBPMObservers();
                }
            }
            try {
                Thread.sleep(time);
            } catch (Exception e) {
                // do nothing
            }
        }
    }

    @Override
    public int getHeartRate() {
        return 60000 / time;
    }

    @Override
    public void registerObserver(BeatObserver o) {
        if (o != null) {
            beatObservers.add(o);
        }
    }

    public void notifyBeatObservers() {
        for (BeatObserver observer :  beatObservers) {
            if (observer != null) {
                observer.updateBeat();
            }
        }
    }

    @Override
    public void removeObserver(BeatObserver o) {
        beatObservers.remove(o);
    }

    @Override
    public void registerObserver(BPMObserver o) {
        if (o != null) {
            bpmObservers.add(o);
        }
    }

    public void notifyBPMObservers() {
        for (BPMObserver observer : bpmObservers) {
            if (observer != null) {
                observer.updateBPM();
            }
        }
    }

    @Override
    public void removeObserver(BPMObserver o) {
        bpmObservers.remove(o);
    }
}
