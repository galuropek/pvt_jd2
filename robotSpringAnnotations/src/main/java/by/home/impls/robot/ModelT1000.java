package by.home.impls.robot;

import by.home.interfaces.Hand;
import by.home.interfaces.Head;
import by.home.interfaces.Leg;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Qualifier(value = "model1")
public class ModelT1000 extends BaseModel implements InitializingBean, DisposableBean {

    private String color;
    private int year;
    private boolean soundEnabled;

    public ModelT1000() {
        super();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ModelT1000 model1() {
        return new ModelT1000();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ModelT1000 model2(){
        return new ModelT1000("Grey", 2021, true);
    }

//    public ModelT1000(Hand hand, Leg leg, Head head) {
//        super(hand, leg, head);
//    }

    public ModelT1000(String color, int year, boolean soundEnabled) {
        this.color = color;
        this.year = year;
        this.soundEnabled = soundEnabled;
    }

//    public ModelT1000(Hand hand, Leg leg, Head head, String color, int year, boolean soundEnabled) {
//        super(hand, leg, head);
//        this.color = color;
//        this.year = year;
//        this.soundEnabled = soundEnabled;
//    }

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
        System.out.println();
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
