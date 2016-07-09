package com.doublebellybuster.controllers;

import org.springframework.stereotype.Controller;

/**
 * Created by alshchetinin on 7/6/2016.
 */
@Controller
public class TestController {

//    private DataSource dataSource;
//    private JdbcTemplate jdbcTemplate;

    /*@Autowired
    public TestController(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }*/

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

    /*@RequestMapping("/dbtest")
    @ResponseBody
    String dbtest() {
        return jdbcTemplate.queryForObject("select VERSION();", String.class);
    }*/
}
