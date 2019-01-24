package by.home.main;

import by.home.impls.robot.ModelT1000;
import by.home.interfaces.Robot;
import by.home.interfaces.RobotCoveyor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("ApplicationContext.xml");

//        ModelT1000 bean = (ModelT1000) context.getBean("t1000");

        RobotCoveyor t1000Conveyor = (RobotCoveyor) context.getBean("t1000Conveyor");

        Robot terminator1 = t1000Conveyor.createRobot();
        Robot terminator2 = t1000Conveyor.createRobot();
        Robot terminator3 = t1000Conveyor.createRobot();

        System.out.println("Terminator1 " + terminator1);
        System.out.println("Terminator2 " + terminator2);
        System.out.println("Terminator3 " + terminator3);
    }
}