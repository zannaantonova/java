package ee.bcs.java.demo.tasks.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;

    public void createAccount(String iban) {
        bankRepository.createAccount(iban);
    }

    public int getAccountBalance(String iban) {
        return bankRepository.getAccountBalance(iban);
    }

    public void depositMoney(String iban, Integer amount) {
        if (amount > 0) {
            int currentBalance = bankRepository.getAccountBalance(iban);
            int newAmount = currentBalance + amount;
            bankRepository.updateBalance(newAmount, iban);
        }
    }

    public void withdrawMoney(String iban, int amount) {
        if (amount > 0) { // kas sa üritad võtta välja negatiivse koguse raha
            int currentBalance = bankRepository.getAccountBalance(iban);
            if(currentBalance >= amount) { // kas sul on piisavalt vabu vahendeid
               int newBalance = currentBalance - amount;
                bankRepository.updateBalance(newBalance, iban);
            }
        }
    }

    public void transferMoney(String from, String to, int amount) {
        if (amount < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "amount must be larger than 0");
        }
        int fromAccountBalance = bankRepository.getAccountBalance(from);
        if (fromAccountBalance >= amount) {
            int newFromAccountBalance = fromAccountBalance - amount;
            bankRepository.updateBalance(newFromAccountBalance, from);
            int toAccountBalance = bankRepository.getAccountBalance(to);
            int newToAccountBalance = toAccountBalance + amount;
            bankRepository.updateBalance(newToAccountBalance, to);
        }

    }
}
