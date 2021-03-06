package by.home.impls.pool;

import by.home.interfaces.Robot;
import by.home.interfaces.RobotPool;

import java.util.Collection;

public class T1000Pool implements RobotPool {

    private Collection<Robot> robotCollection;

    public void setRobotCollection(Collection<Robot> robotCollection) {
        this.robotCollection = robotCollection;
    }

    @Override
    public Collection<Robot> getRobotCollection() {
        return robotCollection;
    }

    public void action(){
        for (Robot robot : robotCollection) {
            robot.action();
        }
    }
}
