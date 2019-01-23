package by.home.main;

import by.home.impls.robot.ModelT1000;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("ApplicationContext.xml");

//        Object bean = context.getBean("t1000");

        //using other constructor
        ModelT1000 bean = (ModelT1000) context.getBean("t1000");
        printBean(bean);

        bean = (ModelT1000) context.getBean("t1000");
        printBean(bean);

//        if (bean instanceof ModelT1000) {
//            ModelT1000 t1000 = (ModelT1000) bean;
//            t1000.action();
//        }
    }

    private static void printBean(ModelT1000 bean) {
        System.out.println(bean);
        System.out.println(bean.getHand());
        System.out.println(bean.getHead());
        System.out.println(bean.getLeg());
        System.out.println("-----------------------------------------------");
    }
}
