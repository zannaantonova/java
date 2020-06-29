package ee.bcs.java.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController()
public class BookController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @GetMapping("")
    public Book getBook() {
        String sql = "SELECT * FROM account WHERE customer_id = :customerId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("customerId", 3);
        jdbcTemplate.query(sql, paramMap, rowMapper);
        Book book = new Book();
        book.setTitle("Lord of the Rings");
        return book;
    }

    @PostMapping("")
    public Book saveBook(@RequestBody Book book) {
        return book;
    }

}
