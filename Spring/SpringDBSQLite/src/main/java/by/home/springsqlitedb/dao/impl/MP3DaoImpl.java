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

    private Class<MP3> aClass = MP3.class;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(MP3 mp3) {
        String sql = "insert into mp3 (name, author) VALUES (?, ?)";
        jdbcTemplate.update(sql, mp3.getName(), mp3.getAuthor());
        System.out.println("insert(): \n" + mp3);
    }

    public void insert(List<MP3> list) {
        for (MP3 mp3 : list) {
            insert(mp3);
        }
    }

    public void delete(MP3 mp3) {
        if (mp3.getId() != null) {
            delete(mp3.getId());
            System.out.println("deleteById():\n" + mp3);
        } else {
            if (mp3.getName() != null && mp3.getAuthor() != null) {
                deleteByFields(mp3);
                System.out.println("deleteByFields():\n" + mp3);
            } else {
                System.out.println("Name and author must be entered!");
            }
        }

    }

    private void delete(Integer id) {
        String sql = "delete from mp3 where id=?";
        jdbcTemplate.update(sql, id);
    }

    private void deleteByFields(MP3 mp3) {
        String sql =
                "delete from mp3 where name='" + mp3.getName()
                        + "' and author='" + mp3.getAuthor() + "'";
        jdbcTemplate.execute(sql);
    }

    //in process...
    public MP3 getMP3byId(int id) {
//        String sql = "select * from mp3 where id=" + id;
//        return jdbcTemplate.queryForObject(sql, aClass);
        return null;
    }

    public List<MP3> getMP3ListByName(String name) {
        return null;
    }

    public List<MP3> getMp3ListByAuthor(String author) {
        return null;
    }
}
