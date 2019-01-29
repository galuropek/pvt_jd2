package by.home.spring.aop.main;

import by.home.spring.aop.objects.FileManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        FileManager fileUtil = (FileManager) context.getBean("fileManager");
        fileUtil.getExtensionCount("C:\\Windows\\System32");
        fileUtil.getExtensionCount("C:\\Windows");
    }
}
