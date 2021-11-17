package ee.bcs.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Lesson4SQLController {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    @GetMapping("banksql/createAccount")
    // http://localhost:8080/banksql/createAccount?accountNumber=EE123
    public String createAccount2(@RequestParam("accountNumber") String accountNumber) {
        String sql = "INSERT INTO accountssql (accountnumber, saldo) VALUES (:sqlaccountnumber, :sqlsaldo)";
        Map<String, Object> paramMap = new HashMap<>();
        int algsaldo = 0;
        paramMap.put("sqlaccountnumber", accountNumber);
        paramMap.put("sqlsaldo", algsaldo);
        jdbcTemplate.update(sql, paramMap);

        String sqltrans = "INSERT INTO transaction (accountnumber, ylekandesumma, saldo) VALUES (:sqlaccountnumbertrans, :sqlylekandesummatrans, :sqlsaldotrans)";
        Map<String, Object> paramMaptrans = new HashMap<>();
        paramMaptrans.put("sqlaccountnumbertrans", accountNumber);
        paramMaptrans.put("sqlsaldotrans", algsaldo);
        paramMaptrans.put("sqlylekandesummatrans", algsaldo);
        jdbcTemplate.update(sqltrans, paramMaptrans);

        return "konto " + accountNumber + " on loodud";
    }


    @GetMapping("banksql/getBalance")
    // http://localhost:8080/banksql/getBalance?accountNumber=EE126
    public String getBalance2(@RequestParam("accountNumber") String accountNumber) {
        String sql = "SELECT saldo FROM accountssql WHERE accountnumber = :sqlaccountnumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlaccountnumber", accountNumber);
        Integer balance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);

        if (balance == null) {
            return "konto pole loodud";
        } else {
            return "konto jääk on " + balance + " eur";
        }


    }


    @GetMapping("banksql/getBalance3/{accountNumber}")
    // http://localhost:8080/banksql/getBalance3/EE123
    public String getBalance3(@PathVariable("accountNumber") String accountNumber) {
        String sql = "SELECT saldo FROM accountssql WHERE accountnumber = :sqlaccountnumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlaccountnumber", accountNumber);
        Integer balance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        if (balance == null) {
            return "konto pole loodud";
        } else {
            return "konto jääk on " + balance + " eur";
        }
    }


    @GetMapping("banksql/depositMoney2")
    // http://localhost:8080/banksql/depositMoney2?accountNumber=EE123&amount=1600
    public String depositMoney2(@RequestParam("accountNumber") String accountNumber, @RequestParam("amount") int amount) {
        //todo oluline, et amount > 0
        String sql = "SELECT saldo FROM accountssql WHERE accountnumber = :sqlaccountnumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlaccountnumber", accountNumber);
        Integer oldBalance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        Integer newBalance = oldBalance + amount;

        if (oldBalance == null) {
            return "konto pole loodud";
        } else {
            if (amount > 0) {
                String sql2 = "UPDATE accountssql SET saldo = :sqlsaldo WHERE accountnumber = :sqlaccountnumber";
                Map<String, Object> paramMap2 = new HashMap<>();
                paramMap2.put("sqlaccountnumber", accountNumber);
                paramMap2.put("sqlsaldo", newBalance);
                jdbcTemplate.update(sql2, paramMap2);

                String sqltrans = "INSERT INTO transaction (saldo, ylekandesumma, accountnumber) VALUES (:sqlsaldotrans, :sqlylekandesummatrans, :sqlaccountnumbertrans)";
                Map<String, Object> paramMaptrans = new HashMap<>();
                paramMaptrans.put("sqlaccountnumbertrans", accountNumber);
                paramMaptrans.put("sqlsaldotrans", newBalance);
                paramMaptrans.put("sqlylekandesummatrans", amount);
                jdbcTemplate.update(sqltrans, paramMaptrans);

                return "kontole lisatud " + amount + " eur. Konto jääk on " + newBalance + " eur";
            } else {
                return "summa peab olema positiivne";
            }
        }
    }


    @GetMapping("banksql/withdrawMoney2")
    // http://localhost:8080/banksql/withdrawMoney2?accountNumber=EE123&amount=1600
    public String withdrawMoney2(@RequestParam("accountNumber") String accountNumber, @RequestParam("amount") int amount) {
        //todo oluline, et amount > 0
        String sql = "SELECT saldo FROM accountssql WHERE accountnumber = :sqlaccountnumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlaccountnumber", accountNumber);
        Integer oldBalance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        Integer newBalance = oldBalance - amount;

        if (oldBalance == null) {
            return "konto pole loodud";
        } else {
            if (amount > 0) {
                String sql2 = "UPDATE accountssql SET saldo = :sqlsaldo WHERE accountnumber = :sqlaccountnumber";
                Map<String, Object> paramMap2 = new HashMap<>();
                paramMap2.put("sqlaccountnumber", accountNumber);
                paramMap2.put("sqlsaldo", newBalance);
                jdbcTemplate.update(sql2, paramMap2);
                return "kontolt võetud välja " + amount + " eur. Konto jääk on " + newBalance + " eur";
            } else {
                return "summa peab olema positiivne";
            }
        }
    }


    @GetMapping("bank2/transferMoney2/{fromAccountNumber}/{toAccountNumber}/{amount}")
    //http://localhost:8080/bank2/transferMoney2/EE123/LT226/400
    public String transferMoney2(@PathVariable("fromAccountNumber") String fromAccountNumber, @PathVariable("toAccountNumber") String toAccountNumber, @PathVariable("amount") Integer amount) {
        String sql = "SELECT saldo FROM accountssql WHERE accountnumber = :sqlaccountnumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlaccountnumber", fromAccountNumber);
        Integer oldFromBalance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);

        String sql2 = "SELECT saldo FROM accountssql WHERE accountnumber = :sqlaccountnumber";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("sqlaccountnumber", toAccountNumber);
        Integer oldToBalance = jdbcTemplate.queryForObject(sql, paramMap2, Integer.class);

        if (oldFromBalance == null && oldToBalance == null) {
            return "kontod pole loodud";
        }
        else if (oldFromBalance < amount) {
            return "kontol pole piisavalt raha";
        }
        else {
            Integer newFromBalance = oldFromBalance - amount;
            Integer newToBalance = oldToBalance + amount;
            if (amount < 0) {
                return "summa peab olema suurem kui 0";
            } else {

                String sql3 = "UPDATE accountssql SET saldo = :sqlsaldo WHERE accountnumber = :sqlaccountnumber";
                Map<String, Object> paramMap3 = new HashMap<>();
                paramMap3.put("sqlaccountnumber", fromAccountNumber);
                paramMap3.put("sqlsaldo", newFromBalance);
                jdbcTemplate.update(sql3, paramMap3);

                String sqltrans1 = "INSERT INTO transaction (accountnumber, ylekandesumma, saldo) VALUES (:sqlaccountnumbertrans1, :sqlylekandesummatrans1, :sqlsaldotrans1)";
                Map<String, Object> paramMaptrans1 = new HashMap<>();
                paramMaptrans1.put("sqlaccountnumbertrans1", fromAccountNumber);
                paramMaptrans1.put("sqlylekandesummatrans1", amount);
                paramMaptrans1.put("sqlsaldotrans1", newFromBalance);
                jdbcTemplate.update(sqltrans1, paramMaptrans1);


                String sql4 = "UPDATE accountssql SET saldo = :sqlsaldo WHERE accountnumber = :sqlaccountnumber";
                Map<String, Object> paramMap4 = new HashMap<>();
                paramMap4.put("sqlaccountnumber", toAccountNumber);
                paramMap4.put("sqlsaldo", newToBalance);
                jdbcTemplate.update(sql4, paramMap4);

                String sqltrans2 = "INSERT INTO transaction (accountnumber, ylekandesumma, saldo) VALUES (:sqlaccountnumbertrans2, :sqlylekandesummatrans2, :sqlsaldotrans2)";
                Map<String, Object> paramMaptrans2 = new HashMap<>();
                paramMaptrans2.put("sqlaccountnumbertrans2", toAccountNumber);
                paramMaptrans2.put("sqlylekandesummatrans2", amount);
                paramMaptrans2.put("sqlsaldotrans2", newToBalance);
                jdbcTemplate.update(sqltrans2, paramMaptrans2);


                return amount + " eur on üle viidud kontolt " + fromAccountNumber + " kontole " + toAccountNumber + ". " + toAccountNumber + " saldo on " + newToBalance + " eur. " + fromAccountNumber + " saldo on " + newFromBalance + " eur.";

            }
        }
    }

    //konto väljavõte

    @GetMapping("bank2/transactiondata/{accountNumber}")
    //http://localhost:8080/bank2/transactiondata/EE123?from=2021-11-01?to=2021-11-01
    public List transactiondata(@PathVariable("accountNumber") String accountNumber, @RequestParam ("from") String from, @RequestParam (value = "to", required = false) String to) {

        String sql = "SELECT * FROM transaction WHERE accountnumber = :sqlaccountnumbertrans";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlaccountnumbertrans", accountNumber);
        if (from != null){
            sql = sql + " AND created > :from";
            LocalDate fromDate = LocalDate.parse(from);
            paramMap.put("from", fromDate);
        }

        if (to != null){
            sql = sql + " AND created < :to";
            LocalDate toDate = LocalDate.parse(to);
            paramMap.put("to", toDate.plusDays(1));
        }

        List<TransactionDTO> result = jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(TransactionDTO.class));
        return result;
    }

}

