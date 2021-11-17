package ee.bcs.java.controller;

import com.fasterxml.jackson.core.ObjectCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Employee2Controller {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    private List<ClietDyo> clients = new ArrayList();


    //http://localhost:8080/client2/createClient?name=John&aadress=USA&age=99
    @GetMapping("client2/createClient")
    public String createClient(@RequestParam("name") String name, @RequestParam("aadress") String aadress, @RequestParam("age") Integer age) {
        //todo, lisa client listi uus klient

        String sql = "INSERT INFO client (name, address) VALUES (:sqlName, :sqlAddress)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlName", name);
        paramMap.put("sqlAddress", aadress);
        jdbcTemplate.update(sql, paramMap);
        return "Klient on loodud";
    }


    // http://localhost:8080/client2/2
    @DeleteMapping("client2/{index}")
    public String deleteClient(@PathVariable("index") int index) {
        //TODO eemalda clients listist indexiga i klient
        String sql = "DELETE FROM client WHERE id = :sqlIndex";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlIndex", index);
        jdbcTemplate.update(sql, paramMap);
        return "kustutatud";
    }


    // http://localhost:8080/client2/1?name=Kuku&aadress=USA&age=99
    @PutMapping("client2/{index}")
    public String updateClient(@PathVariable("index") Integer index, @RequestBody ClietDyo client) {
        //TODO kirjuta indeksiga i klient üle uute andmetega
        String sql = "UPDATE client SET name = :sqlName WHERE id = :sqlId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlID", index);
        paramMap.put("sqlName", client.getName());
        jdbcTemplate.update(sql, paramMap);
        return "uuendatud";


/*        String sql = "UPDATE client SET name = :sqlName, address = :sqlAddress WHERE id = :sqlId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlID", index);
        paramMap.put("sqlName", name);
        paramMap.put("sqlAddress", aadress);
        jdbcTemplate.update(sql, paramMap);
        return "uuendatud";

 */
    }


    // http://localhost:8080/client2
    @GetMapping("client2")
    //TODO tagasta klientide listi
    public List<ClietDyo> getAllClients() {
        String sql = "SELECT * FROM client";
        Map<String, Object> paramMap = new HashMap<>();
        return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(ClietDyo.class));

    }

    // http://localhost:8080/client2/1
    @GetMapping("client2/{index}")
    public ClietDyo getClient(@PathVariable("index") Integer index) {
        //TODO tagasta üks klient
        String sql = "SELECT * FROM client WHERE id = :sqlId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlId", index);
        return jdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<>(ClietDyo.class));


    }

    /*
    //http://localhost:8080/client2/getName/1
    @GetMapping("client2/getName/{index}")
    public String getName(@PathVariable("id") int index) {
        String sql = "SELECt name FROM client WHERE id = :sqlid";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlId", index);
        String name = jdbcTemplate.queryForObject(sql, paramMap, String.class);
        return name;
    }

     */

    /*
    // http://localhost:8080/client2
    @GetMapping("client2")
    //TODO tagasta klientide listi
    public List<ClietDyo> getAllClients() {
        String sql = "SELECT * FROM client";
        Map<String, Object> paramMap = new HashMap<>();
        List<ClietDyo> result = jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(ClietDyo.class));
        return result;

    }

     */
}

