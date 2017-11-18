package io.khasang.hotel.model;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CreateTable {
    private JdbcTemplate jdbcTemplate;
    private String message;

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CreateTable() {
    }

    public String createTableStatus() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS films");
            jdbcTemplate.execute("CREATE TABLE PUBLIC.films \n" +
                    "(\n" +
                    "id INTEGER NOT NULL , \n" +
                    "name CHARACTER VARYING (255) NOT NULL, \n" +
                    "CONSTRAINT firstkey PRIMARY KEY (id) \n" +
                    ");");
            message = "table films created\n";
        } catch (Exception e) {
            message = "Table \"films\" creation failed. " + e + "\n";
        }
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS public.ingredients");
            jdbcTemplate.execute("CREATE TABLE public.ingredients\n" +
                    "(\n" +
                    "    id integer NOT NULL,\n" +
                    "    name character varying COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                    "    cost integer NOT NULL,\n" +
                    "    CONSTRAINT ingredients_pkey PRIMARY KEY (id)\n" +
                    ")");
            message += "table ingredients created";
        } catch (Exception e) {
            message += "Table \"ingredients\" creation failed. " + e;
        }
        return message;
    }
}

