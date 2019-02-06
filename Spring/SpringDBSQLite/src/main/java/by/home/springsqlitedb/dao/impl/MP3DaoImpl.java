package by.home.springsqlitedb.dao.impl;

import by.home.springsqlitedb.dao.MP3Dao;
import by.home.springsqlitedb.model.MP3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Component("mp3Dao")
public class MP3DaoImpl implements MP3Dao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    private Class<MP3> aClass = MP3.class;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void insert(MP3 mp3) {
        String sql = "insert into mp3 (name, author) VALUES (:name, :author)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", mp3.getName());
        params.addValue("author", mp3.getAuthor());
        jdbcTemplate.update(sql, params);
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
        String sql = "delete from mp3 where id=:id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("")
        jdbcTemplate.update(sql, id);
    }

    private void deleteByFields(MP3 mp3) {
        String sql =
                "delete from mp3 where name='" + mp3.getName()
                        + "' and author='" + mp3.getAuthor() + "'";
        jdbcTemplate.execute(sql);
    }

    //in processing...
    public MP3 getMP3ById(int id) {
        String sql = "select * from mp3 where id=" + id;
        System.out.println("getMP3ListById():\n");
        return jdbcTemplate.queryForObject(sql, new MP3RowMapper());
    }

    public List<MP3> getMP3ListByName(String name) {
        String sql = "select * from mp3 where upper(name) like '%" + name.toUpperCase() + "%'";
        System.out.println("getMP3ListByName():\n");
        return jdbcTemplate.query(sql, new MP3RowMapper());
    }

    public List<MP3> getMp3ListByAuthor(String author) {
        String sql = "select * from mp3 where upper(author) like '%" + author.toUpperCase() + "%'";
        System.out.println("getMp3ListByAuthor():\n");
        return jdbcTemplate.query(sql, new MP3RowMapper());
    }

    public int getCount() {
        String sql = "select count(*) from mp3";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    private static final class MP3RowMapper implements RowMapper<MP3> {

        public MP3 mapRow(ResultSet resultSet, int i) throws SQLException {
            MP3 mp3 = new MP3();
            mp3.setId(resultSet.getInt("id"));
            mp3.setName(resultSet.getString("name"));
            mp3.setAuthor(resultSet.getString("author"));
            return mp3;
        }
    }
}