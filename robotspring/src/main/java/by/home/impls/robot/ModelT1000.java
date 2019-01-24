package by.home.impls.robot;

import by.home.interfaces.Hand;
import by.home.interfaces.Head;
import by.home.interfaces.Leg;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ModelT1000 extends BaseModel implements InitializingBean, DisposableBean {

    private String color;
    private int year;
    private boolean soundEnabled;

    public ModelT1000() {
        super();
    }

    public ModelT1000(Hand hand, Leg leg, Head head) {
        super(hand, leg, head);
    }

    public ModelT1000(String color, int year, boolean soundEnabled) {
        this.color = color;
        this.year = year;
        this.soundEnabled = soundEnabled;
    }

    public ModelT1000(Hand hand, Leg leg, Head head, String color, int year, boolean soundEnabled) {
        super(hand, leg, head);
        this.color = color;
        this.year = year;
        this.soundEnabled = soundEnabled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isSoundEnabled() {
        return soundEnabled;
    }

    public void setSoundEnabled(boolean soundEnabled) {
        this.soundEnabled = soundEnabled;
    }

    @Override
    public void action() {
        getHead().calc();
        getHand().catchSomething();
        getLeg().go();
        System.out.println("Color: " + color);
        System.out.println("Year: " + year);
        System.out.println("Can play sounds: " + soundEnabled);
    }

    @Override
    public void dance() {
        System.out.println("T1000 is dancing!");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this + " - method destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this + " - method init()");
    }
}
