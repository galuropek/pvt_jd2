package by.home.main;

import by.home.impls.robot.ModelT1000;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Object bean = context.getBean("t1000");

        if (bean instanceof ModelT1000) {
            ModelT1000 t1000 = (ModelT1000) bean;
            t1000.dance();
        }
    }
}