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
        // create table
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS films");
            jdbcTemplate.execute("CREATE TABLE PUBLIC.films \n" +
                    "(\n" +
                    "id INTEGER NOT NULL , \n" +
                    "name CHARACTER VARYING (255) NOT NULL, \n" +
                    "CONSTRAINT firstkey PRIMARY KEY (id) \n" +
                    ");");
            message = "table films was created<br/>";
        } catch (Exception e) {
            message = "Table \"films\" creation failed. <br/>" + e + "<br/>";
        }
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS public.ingredients");
            jdbcTemplate.execute("CREATE TABLE public.ingredients\n" +
                    "(\n" +
                    "    id integer NOT NULL,\n" +
                    "    name character varying COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                    "    cost integer NOT NULL,\n" +
                    "    CONSTRAINT ingredients_pkey PRIMARY KEY (id)\n" +
                    ");");
            message += "table ingredients created<br/>";
        } catch (Exception e) {
            message += "Table \"ingredients\" creation failed. " + e;
        }

        // insert data
        try {
            jdbcTemplate.update("INSERT INTO public.ingredients (id, name, cost) VALUES (1, 'ветчина', 36);");
            jdbcTemplate.update("INSERT INTO public.ingredients (id, name, cost) VALUES (2, 'маслины', 17);");
            jdbcTemplate.update("INSERT INTO public.ingredients (id, name, cost) VALUES (3, 'брокколи', 15);");
            jdbcTemplate.update("INSERT INTO public.ingredients (id, name, cost) VALUES (4, 'шампиньоны', 24);");

            message += "\ndata was added in table \"ingredients\"<br/>";
        } catch (Exception e) {
            message = "\n insertion failed.\n ";
            System.out.println(message);
            e.printStackTrace();
        }

        // update data
        try {
            jdbcTemplate.update("UPDATE public.ingredients SET cost = 10 WHERE id = 3;");
            jdbcTemplate.update("UPDATE public.ingredients SET cost = 40 WHERE name = 'ветчина';");

            message += "\ndata was updated in table \"ingredients\"<br/>";
        } catch (Exception e) {
            message = "\n update failed.\n ";
            System.out.println(message);
            e.printStackTrace();
        }

        // delete data
        try {
            jdbcTemplate.update("DELETE FROM ingredients WHERE cost < 15;");

            message += "\ndata was deleted in table \"ingredients\"<br/>";
        } catch (Exception e) {
            message = "\n update failed.\n ";
            System.out.println(message);
            e.printStackTrace();
        }

        // select data
        try {
            jdbcTemplate.execute("SELECT * FROM public.ingredients order by id;");

            message += "\ndata was selected from table \"ingredients\"<br/>";
        } catch (Exception e) {
            message = "\n selection failed.\n ";
            System.out.println(message);
            e.printStackTrace();
        }

        return message;
    }
}

