
public class Stereo {
    private String location = "";
    private int volume = 10;

    public Stereo(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " Stereo is On");
    }

    public void off() {
        System.out.println(location + " Stereo is Off");
    }

    public void setCD() {
        System.out.println(location + " Stereo is set for CD input");
    }

    public void setDVD() {
        System.out.println(location + " Stereo is set for DVD input");
    }

    public void setRadio() {
        System.out.println(location + " Stereo is set for Radio input");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println(location + " Stereo volume set to " + this.volume);
    }
}
