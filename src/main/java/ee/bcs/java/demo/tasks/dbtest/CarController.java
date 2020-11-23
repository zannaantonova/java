package ee.bcs.java.demo.tasks.dbtest;

import ee.bcs.java.demo.tasks.web.SampleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CarController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @GetMapping("car/regnr")
    public String getRegNumber(@RequestParam("id") Integer i){
        String sql = "SELECT reg_num FROM car WHERE id = :a";
        Map paramMap = new HashMap();
        paramMap.put("a", i);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }

    @GetMapping("car/brand")
    public List<String> getCarsByBrand(@RequestParam("id") String id){
        String sql = "SELECT reg_num FROM car WHERE lower(name) = :a ORDER BY id";
        Map paraMap = new HashMap();
        paraMap.put("a", id.toLowerCase());
        return jdbcTemplate.queryForList(sql, paraMap, String.class);
    }
    // http://localhost:8080/car/update?q=123ABC&w=1
    @GetMapping("car/update")
    public void updateRegNr(@RequestParam("q") String q1,
                            @RequestParam("w") Integer w1){
        String sql = "UPDATE car SET reg_num = :q WHERE id = :w";
        Map paramMap = new HashMap();
        paramMap.put("q", q1);
        paramMap.put("w", w1);
        jdbcTemplate.update(sql,paramMap);
    }

    @GetMapping("allcars")
    public List<Car> getAllCars(){
        String sql = "SELECT * FROM car";
        Map paramMap = new HashMap();
        return jdbcTemplate.query(sql, paramMap, new CarRowMapper());
    }

    // Luua tabel raamatud (id, nimi, aasta, autor)
    // Luua teenus mis otsib kõik raamatud autori järgi


    private class CarRowMapper implements RowMapper<Car> {
        @Override
        public Car mapRow(ResultSet resultSet, int i) throws SQLException {
            Car qwerty = new Car();
            qwerty.id = resultSet.getInt("id");
            qwerty.name = resultSet.getString("name");
            qwerty.regnr = resultSet.getString("reg_num");
            return qwerty;
        }
    }
}
