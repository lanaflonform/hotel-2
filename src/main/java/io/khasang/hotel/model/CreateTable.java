package io.khasang.hotel.model;

import org.springframework.jdbc.core.JdbcTemplate;

public class CreateTable {
    private JdbcTemplate jdbcTemplate;

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CreateTable() {
    }

    public String createTableStatus() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS clients");
        jdbcTemplate.execute("CREATE TABLE public.clients \n" +
                "(\n" +
                "  id integer NOT NULL,\n" +
                "  family character varying(255),\n" +
                "  name character varying(255),\n" +
                "  secondName character varying(255),\n" +
                "  dateOfBirth date ,\n" +
                "  phone character varying(255),\n" +
                "  level integer,\n" +
                "  CONSTRAINT clients_pkey PRIMARY KEY (id)\n" +
                ")");
        return "table created";
    }
}
