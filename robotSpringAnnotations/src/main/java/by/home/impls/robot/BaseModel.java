package by.home.impls.robot;

import by.home.interfaces.Hand;
import by.home.interfaces.Head;
import by.home.interfaces.Leg;
import by.home.interfaces.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public abstract class BaseModel implements Robot {

    @Autowired
    @Qualifier("sonyHand")
    private Hand hand;

    @Autowired
    @Qualifier("sonyLeg")
    private Leg leg;

    @Autowired
    @Qualifier("sonyHead")
    private Head head;

    public BaseModel() {
        System.out.println(this + " - BaseModel constructor");
    }

//    public BaseModel(Hand hand, Leg leg, Head head) {
//        this.hand = hand;
//        this.leg = leg;
//        this.head = head;
//    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Leg getLeg() {
        return leg;
    }

    public void setLeg(Leg leg) {
        this.leg = leg;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }
}
