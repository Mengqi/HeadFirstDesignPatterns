import javax.swing.JProgressBar;

public class BeatBar extends JProgressBar implements Runnable {
    private static final long serialVersionUID = -2097068813160232333L;

    JProgressBar progressBar;
    Thread thread;

    public BeatBar() {
        thread = new Thread(this);
        setMaximum(100);
        thread.start();
    }

    @Override
    public void run() {
        for (;;) {
            int value = getValue();
            value = (int)(value * .75);
            setValue(value);
            repaint();
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                // do nothing
            }
        }
    }

}
