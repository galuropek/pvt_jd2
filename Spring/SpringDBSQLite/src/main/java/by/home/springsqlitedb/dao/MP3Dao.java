package by.home.springsqlitedb.dao;

import by.home.springsqlitedb.model.MP3;

import java.util.List;

public interface MP3Dao {

    void insert(MP3 mp3);

    void delete(MP3 mp3);

    MP3 getMP3byId(int id);

    List<MP3> getMP3ListByName(String name);

    List<MP3> getMp3ListByAuthor(String author);

}
