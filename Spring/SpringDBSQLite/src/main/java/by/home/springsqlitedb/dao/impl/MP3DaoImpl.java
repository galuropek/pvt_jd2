package by.home.springsqlitedb.dao.impl;

import by.home.springsqlitedb.dao.MP3Dao;
import by.home.springsqlitedb.model.MP3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        delete(mp3.getId());
        System.out.println("delete():\n" + mp3);
    }

    public List<MP3> getAll() {
        String sql = "select * from mp3";
        return jdbcTemplate.query(sql, new MP3ResultSetExtractor());
    }

    private void delete(Integer id) {
        String sql = "delete from mp3 where id=:id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        jdbcTemplate.update(sql, params);
    }


    public MP3 getMP3ById(int id) {
        String sql = "select * from mp3 where id=:id";
        System.out.println("getMP3ListById():\n");
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return jdbcTemplate.queryForObject(sql, params, new MP3RowMapper());
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
        return jdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
    }

    private static final class MP3RowMapper implements RowMapper<MP3> {

        public MP3 mapRow(ResultSet resultSet, int i) throws SQLException {
            MP3 mp3 = copyMP3Property(resultSet);
            return mp3;
        }
    }

    private static final class MP3ResultSetExtractor implements ResultSetExtractor<List<MP3>>{

        public List<MP3> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<MP3> list = new ArrayList<MP3>();
                while (resultSet.next()){
                    MP3 mp3 = copyMP3Property(resultSet);
                    list.add(mp3);
                }
                return list;
        }

    }

    private static MP3 copyMP3Property(ResultSet resultSet) throws SQLException {
        MP3 mp3 = new MP3();
        mp3.setId(resultSet.getInt("id"));
        mp3.setName(resultSet.getString("name"));
        mp3.setAuthor(resultSet.getString("author"));
        return mp3;
    }
}