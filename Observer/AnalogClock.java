package Observer;

public class AnalogClock implements Observer, DiplayTime {

    private int hour;
    private int minute;
    private int second;
    private Subject clock;

    public AnalogClock(Subject clock) {
        this.clock = clock;
        this.clock.registerObserver(this);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    @Override
    public void update(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
        display();
    }

    @Override
    public void display() {
        System.out.println("This is a analog clock and the current time is: " + hour + ":" + minute + ":" + second);
    }
}
