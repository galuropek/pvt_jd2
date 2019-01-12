package by.pvt.pojo;

import by.pvt.bean.PersonImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-config-simple.xml");

        PersonImpl person = (PersonImpl) applicationContext.getBean("person");

        System.out.println(person);
    }
}
