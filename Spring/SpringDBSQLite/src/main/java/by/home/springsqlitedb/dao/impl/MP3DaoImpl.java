package by.home.springsqlitedb.dao.impl;

import by.home.springsqlitedb.dao.MP3Dao;
import by.home.springsqlitedb.model.MP3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component("mp3Dao")
public class MP3DaoImpl implements MP3Dao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(MP3 mp3) {
        String sql = "insert into mp3 (name, author) VALUES (?, ?)";
        jdbcTemplate.update(sql, mp3.getName(), mp3.getAuthor());
        System.out.println("insert(): \n" + mp3);
    }

    public void delete(MP3 mp3) {
        if (mp3.getId() != null) {
            deleteById(mp3);
        } else {
            if (mp3.getName() != null && mp3.getAuthor() != null)
                deleteByFields(mp3);
            else
                System.out.println("Name and author must be entered!");
        }
    }

    private void deleteById(MP3 mp3) {
        String sql = "delete from mp3 where id=" + mp3.getId();
        jdbcTemplate.execute(sql);
    }

    private void deleteByFields(MP3 mp3) {
        String sql =
                "delete from mp3 where name='"
                + mp3.getName()
                + "' and author='"
                + mp3.getAuthor() + "'";
        jdbcTemplate.execute(sql);
    }

    public MP3 getMP3byId(int id) {
        return null;
    }

    public List<MP3> getMP3ListByName(String name) {
        return null;
    }

    public List<MP3> getMp3ListByAuthor(String author) {
        return null;
    }
}
