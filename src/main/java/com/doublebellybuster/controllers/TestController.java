package com.doublebellybuster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;

/**
 * Created by alshchetinin on 7/6/2016.
 */
@Controller
public class TestController {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TestController(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /*@RequestMapping("/envvars")
    void envvars(HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        PrintStream out = new PrintStream(response.getOutputStream());

        Map<String, String> envVars = System.getenv();

        for (Map.Entry<String, String> entry : envVars.entrySet()) {
            out.println(entry.getKey() + "=" + entry.getValue());
        }

        out.flush();
    }*/

    @RequestMapping("/dbtest")
    @ResponseBody
    String dbtest() {
        return jdbcTemplate.queryForObject("select VERSION();", String.class);
    }
}
