package io.khasang.hotel.model;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public class TableUtils {
    private static final int ID = 1;
    private JdbcTemplate jdbcTemplate;

    public TableUtils(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public TableUtils() {
    }

    public String createStatus() {

        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS films");
            jdbcTemplate.execute("CREATE TABLE PUBLIC.films \n" +
                    "(\n" +
                    "id INTEGER NOT NULL , \n" +
                    "name CHARACTER VARYING (255) NOT NULL, \n" +
                    "cinema_id INTEGER, \n" +
                    "CONSTRAINT firstkey PRIMARY KEY (id) \n" +
                    ");");
            jdbcTemplate.execute("DROP TABLE IF EXISTS cinemas");
            jdbcTemplate.execute("CREATE TABLE PUBLIC.cinemas \n" +
                    "(\n" +
                    "id INTEGER NOT NULL , \n" +
                    "name CHARACTER VARYING (255) NOT NULL, \n" +
                    "CONSTRAINT secondkey PRIMARY KEY (id) \n" +
                    ");");
            return "tables created";
        } catch (Exception e) {
            return "Tables creation failed: " + e;
        }
    }

    public String selectStatus() {
        try {
            jdbcTemplate.execute("SELECT * FROM public.films;");
            return "select ok";
        } catch (DataAccessException e) {
            return "Can't access to db: " + e;
        }
    }

    public String selectWithJoinStatus() {
        try {
            String sql = "SELECT f.name FROM public.films f JOIN public.cinemas c ON f.cinema_id = c.id WHERE c.name = ?;";
            List<String> rows = jdbcTemplate.queryForList(sql,new Object[] {"Космос"}, String.class);
            return "select with join ok: " + rows;
        } catch (DataAccessException e) {
            return "Can't select from db: " + e;
        }
    }

    public String selectWithEmbeddedSelectStatus() {
        try {
            String sql = "SELECT f.name FROM public.films f WHERE f.cinema_id IN (SELECT c.id FROM public.cinemas c WHERE c.name = ?);";
            List<String> rows = jdbcTemplate.queryForList(sql,new Object[] {"Космос"}, String.class);
            return "select with embedded select ok: " + rows;
        } catch (DataAccessException e) {
            return "Can't select from db: " + e;
        }
    }

    public String insertStatus() {
        try {
            String sql = "INSERT INTO public.films (id, name, cinema_id) VALUES (?, ?, ?);";
            jdbcTemplate.update(sql, ID, "Титаник", ID + 1);
            jdbcTemplate.update(sql, ID + 1, "Тор", ID);
            jdbcTemplate.update(sql, ID + 2, "Убить Билла", ID + 1);

            sql = "INSERT INTO public.cinemas (id, name) VALUES (?, ?);";
            jdbcTemplate.update(sql, ID, "Заря");
            jdbcTemplate.update(sql, ID + 1, "Космос");
            jdbcTemplate.update(sql, ID + 2, "Пассаж");
            return "insert ok";
        } catch (DataAccessException e) {
            return "Can't insert to db: " + e;
        }
    }

    public String updateStatus() {
        try {
            jdbcTemplate.update("UPDATE public.films \n" +
                    "SET name = ? WHERE id = ?;",  "some film2", ID);
            return "update ok";
        } catch (DataAccessException e) {
            return "Can't update in db: " + e;
        }
    }

    public String deleteStatus() {
        try {
            jdbcTemplate.update("DELETE FROM public.films WHERE id = ?;", ID);
            return "delete ok";
        } catch (DataAccessException e) {
            return "Can't delete from db: " + e;
        }
    }
}
