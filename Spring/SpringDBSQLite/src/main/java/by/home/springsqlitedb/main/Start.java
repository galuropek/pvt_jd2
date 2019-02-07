package by.home.springsqlitedb.main;

import by.home.springsqlitedb.dao.impl.MP3DaoImpl;
import by.home.springsqlitedb.model.MP3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

    public static void main(String[] args) {
        MP3 mp3 = new MP3();
        mp3.setName("Bohemian Rhapsody");
        mp3.setAuthor("Queen");

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        MP3DaoImpl mp3Dao = (MP3DaoImpl) context.getBean("mp3Dao");

        mp3Dao.insert(mp3);
//        mp3Dao.delete(mp3);
        System.out.println(mp3Dao.getMP3ById(22));
        System.out.println("--------------------------------------------");
        System.out.println(mp3Dao.getMP3ListByName("hello"));
        System.out.println("--------------------------------------------");
        System.out.println(mp3Dao.getMp3ListByAuthor("linkin"));
        System.out.println("--------------------------------------------");
        System.out.println("Count mp3: " + mp3Dao.getCount());
        System.out.println(mp3Dao.getAll());
    }
}
