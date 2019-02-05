package by.home.springsqlitedb.main;

import by.home.springsqlitedb.dao.impl.MP3DaoImpl;
import by.home.springsqlitedb.model.MP3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

    public static void main(String[] args) {
        MP3 mp3 = new MP3();
        mp3.setName("Jumpsuit");
        mp3.setAuthor("Twenty One Pilots");

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        MP3DaoImpl mp3Dao = (MP3DaoImpl) context.getBean("mp3Dao");

        mp3Dao.insert(mp3);
    }
}
