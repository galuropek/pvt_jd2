package by.home.main;

import by.home.impls.pool.T1000Pool;
import by.home.impls.robot.ModelT1000;
import by.home.interfaces.Robot;
import by.home.interfaces.RobotCoveyor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("ApplicationContext.xml");

        ModelT1000 t1000 = (ModelT1000) context.getBean("t1000");
        t1000.action();

    }
}