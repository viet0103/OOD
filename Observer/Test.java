package Observer;

public class Test {
    public static void main(String[] args) {
        Clock clock = new Clock();
        DigitalClock digitalClock = new DigitalClock(clock);
        AnalogClock analogClock = new AnalogClock(clock);

        clock.start();
    }
}