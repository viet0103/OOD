package Observer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Clock implements Subject {

    private ArrayList<Observer> observers;
    private int hour;
    private int minute;
    private int second;

    public Clock() {
        observers = new ArrayList<Observer>();
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

    public void setTime(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
        notifyObservers();
    }

    public void start() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                setTime(Calendar.getInstance().getTime().getHours(), Calendar.getInstance().getTime().getMinutes(), Calendar.getInstance().getTime().getSeconds());
                System.out.println("----------------------------------------------------------------");
            }
            
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.stream().forEach((observer) -> observer.update(hour, minute, second));
    }

}
