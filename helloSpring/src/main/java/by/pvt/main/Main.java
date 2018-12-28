package by.pvt.main;

import by.pvt.bean.PersonImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-config2.xml");

        PersonImpl person = (PersonImpl) applicationContext.getBean("person");

        System.out.println(person.getAddress().getStreet() + ", " +
                person.getAddress().getCity());

        System.out.println(person.getName() + " " +
                person.getSecondName());
    }
}
