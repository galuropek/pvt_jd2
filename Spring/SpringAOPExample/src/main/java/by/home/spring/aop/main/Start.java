package by.home.spring.aop.main;

import by.home.spring.aop.objects.SomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        SomeService service = (SomeService) context.getBean("someService");
        double val = service.getDoubleValue();

    }
}
