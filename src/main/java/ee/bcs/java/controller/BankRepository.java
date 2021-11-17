package ee.bcs.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BankRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void addDataToaccountssql(String accountNumber) {
        String sql = "INSERT INTO accountssql (accountnumber, saldo) VALUES (:sqlaccountnumber, :sqlsaldo)";
        Map<String, Object> paramMap = new HashMap<>();
        int algsaldo = 0;
        paramMap.put("sqlaccountnumber", accountNumber);
        paramMap.put("sqlsaldo", algsaldo);
        jdbcTemplate.update(sql, paramMap);
    }

    public void addDataTotransaction(String accountNumber) {
        String sqltrans = "INSERT INTO transaction (accountnumber, ylekandesumma, saldo) VALUES (:sqlaccountnumbertrans, :sqlylekandesummatrans, :sqlsaldotrans)";
        Map<String, Object> paramMaptrans = new HashMap<>();
        int algsaldo = 0;
        paramMaptrans.put("sqlaccountnumbertrans", accountNumber);
        paramMaptrans.put("sqlsaldotrans", algsaldo);
        paramMaptrans.put("sqlylekandesummatrans", algsaldo);
        jdbcTemplate.update(sqltrans, paramMaptrans);
    }

    public Integer askForSaldo(String accountNumber) {
        //todo oluline, et amount > 0
        String sql = "SELECT saldo FROM accountssql WHERE accountnumber = :sqlaccountnumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlaccountnumber", accountNumber);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    public void updateaccountssql(String accountNumber, int newBalance) {
        String sql2 = "UPDATE accountssql SET saldo = :sqlsaldo WHERE accountnumber = :sqlaccountnumber";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("sqlaccountnumber", accountNumber);
        paramMap2.put("sqlsaldo", newBalance);
        jdbcTemplate.update(sql2, paramMap2);
    }

    public void updatetransaction(String accountNumber, int newBalance, int amount) {
        String sqltrans = "INSERT INTO transaction (saldo, ylekandesumma, accountnumber) VALUES (:sqlsaldotrans, :sqlylekandesummatrans, :sqlaccountnumbertrans)";
        Map<String, Object> paramMaptrans = new HashMap<>();
        paramMaptrans.put("sqlaccountnumbertrans", accountNumber);
        paramMaptrans.put("sqlsaldotrans", newBalance);
        paramMaptrans.put("sqlylekandesummatrans", amount);
        jdbcTemplate.update(sqltrans, paramMaptrans);
    }


    public void updateaccountssqlFrom(String fromAccountNumber, int newFromBalance){
        String sql3 = "UPDATE accountssql SET saldo = :sqlsaldo WHERE accountnumber = :sqlaccountnumber";
        Map<String, Object> paramMap3 = new HashMap<>();
        paramMap3.put("sqlaccountnumber", fromAccountNumber);
        paramMap3.put("sqlsaldo", newFromBalance);
        jdbcTemplate.update(sql3, paramMap3);
    }

    public void updatetransactionFrom(String fromAccountNumber, int newFromBalance, int amount){
        String sqltrans1 = "INSERT INTO transaction (accountnumber, ylekandesumma, saldo) VALUES (:sqlaccountnumbertrans1, :sqlylekandesummatrans1, :sqlsaldotrans1)";
        Map<String, Object> paramMaptrans1 = new HashMap<>();
        paramMaptrans1.put("sqlaccountnumbertrans1", fromAccountNumber);
        paramMaptrans1.put("sqlylekandesummatrans1", amount);
        paramMaptrans1.put("sqlsaldotrans1", newFromBalance);
        jdbcTemplate.update(sqltrans1, paramMaptrans1);
    }

    public void updateaccountssqlTo(String toAccountNumber, int newToBalance){
        String sql4 = "UPDATE accountssql SET saldo = :sqlsaldo WHERE accountnumber = :sqlaccountnumber";
        Map<String, Object> paramMap4 = new HashMap<>();
        paramMap4.put("sqlaccountnumber", toAccountNumber);
        paramMap4.put("sqlsaldo", newToBalance);
        jdbcTemplate.update(sql4, paramMap4);
    }
    public void updatetransactionTo(String toAccountNumber, int amount, int newToBalance){
        String sqltrans2 = "INSERT INTO transaction (accountnumber, ylekandesumma, saldo) VALUES (:sqlaccountnumbertrans2, :sqlylekandesummatrans2, :sqlsaldotrans2)";
        Map<String, Object> paramMaptrans2 = new HashMap<>();
        paramMaptrans2.put("sqlaccountnumbertrans2", toAccountNumber);
        paramMaptrans2.put("sqlylekandesummatrans2", amount);
        paramMaptrans2.put("sqlsaldotrans2", newToBalance);
        jdbcTemplate.update(sqltrans2, paramMaptrans2);
    }

    public List listData(String accountNumber, String from, String to){
        String sql = "SELECT * FROM transaction WHERE accountnumber = :sqlaccountnumbertrans";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlaccountnumbertrans", accountNumber);
        if (from != null) {
            sql = sql + " AND created > :from";
            LocalDate fromDate = LocalDate.parse(from);
            paramMap.put("from", fromDate);
        }

        if (to != null) {
            sql = sql + " AND created < :to";
            LocalDate toDate = LocalDate.parse(to);
            paramMap.put("to", toDate.plusDays(1));
        }

        return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(TransactionDTO.class));

    }
}

