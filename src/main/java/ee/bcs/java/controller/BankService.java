package ee.bcs.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BankService {


    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public String createAccount2(String accountNumber) {
        bankRepository.addDataToaccountssql(accountNumber);
        bankRepository.addDataTotransaction(accountNumber);
        return "konto " + accountNumber + " on loodud";
    }

    public String getBalance3(String accountNumber) {
        Integer balance = bankRepository.askForSaldo(accountNumber);
        if (balance == null) {
            return "konto pole loodud";
        } else {
            return "konto jääk on " + balance + " eur";
        }


    }

    public String depositMoney2(String accountNumber, int amount) {
        Integer oldBalance = bankRepository.askForSaldo(accountNumber);
        Integer newBalance = oldBalance + amount;

        if (oldBalance == null) {
            return "konto pole loodud";
        } else {
            if (amount > 0) {
                bankRepository.updateaccountssql(accountNumber, newBalance);
                bankRepository.updatetransaction(accountNumber, newBalance, amount);

                return "kontole lisatud " + amount + " eur. Konto jääk on " + newBalance + " eur";
            } else {
                return "summa peab olema positiivne";
            }
        }
    }

    public String withdrawMoney2(String accountNumber, int amount) {
        //todo oluline, et amount > 0
        Integer oldBalance = bankRepository.askForSaldo(accountNumber);
        Integer newBalance = oldBalance - amount;

        if (oldBalance == null) {
            return "konto pole loodud";
        } else {
            if (amount > 0) {
                bankRepository.updateaccountssql(accountNumber, newBalance);
                bankRepository.updatetransaction(accountNumber, newBalance, amount);

                return "kontolt võetud välja " + amount + " eur. Konto jääk on " + newBalance + " eur";
            } else {
                return "summa peab olema positiivne";
            }
        }
    }


    public String transferMoney2(String fromAccountNumber, String toAccountNumber, Integer amount) {
        Integer oldFromBalance = bankRepository.askForSaldo(fromAccountNumber);
        Integer oldToBalance = bankRepository.askForSaldo(toAccountNumber);

        if (oldFromBalance == null && oldToBalance == null) {
            return "kontod pole loodud";
        } else if (oldFromBalance < amount) {
            return "kontol pole piisavalt raha";
        } else {
            Integer newFromBalance = oldFromBalance - amount;
            Integer newToBalance = oldToBalance + amount;
            if (amount < 0) {
                return "summa peab olema suurem kui 0";
            } else {

                bankRepository.updateaccountssqlFrom(fromAccountNumber, newFromBalance);
                bankRepository.updatetransactionFrom(fromAccountNumber, newFromBalance, amount);
                bankRepository.updateaccountssqlTo(toAccountNumber, newToBalance);
                bankRepository.updatetransactionTo(toAccountNumber, amount, newToBalance);


                return amount + " eur on üle viidud kontolt " + fromAccountNumber + " kontole " + toAccountNumber + ". " + toAccountNumber + " saldo on " + newToBalance + " eur. " + fromAccountNumber + " saldo on " + newFromBalance + " eur.";

            }
        }
    }

    public List transactiondata(String accountNumber, String from, String to) {

        return bankRepository.listData(accountNumber, from, to);
    }

}


