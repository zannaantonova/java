package ee.bcs.java.demo.tasks.lesson1.sample.bank;

import ee.bcs.java.demo.tasks.lesson1.sample.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SampleBankService {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private SampleBankRepository bankRepository;

    @Autowired
    private AccountRepository accountRepository;

    public void createAccount(String accountNumber){
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setBalance(0.0);
        accountRepository.save(account);
    }

    public double getBalance(String accountNumber) {
        return accountRepository.getAccountByAccountNumber(accountNumber).getBalance();
        //return bankRepository.getBalance(accountNumber);
    }

    public void depositMoney(String accountNumber, double amount) {
        if(amount > 0){
            Account account = accountRepository.getAccountByAccountNumber(accountNumber);
            double newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
            accountRepository.save(account);
        }
        /*        if(amount > 0){
            double balance = bankRepository.getBalance(accountNumber);
            double newBalance = balance + amount;
            bankRepository.updateAccountBalance(accountNumber, newBalance);
        }*/
    }

    public void transferMoney(String fromAccount, String toAccount, Double amount) {
        if(amount > 0){
            double fromAccountBalance = bankRepository.getBalance(fromAccount);
            if (fromAccountBalance >= amount) {
                bankRepository.updateAccountBalance(fromAccount, fromAccountBalance - amount);
                double toAccountBalance = bankRepository.getBalance(toAccount);
                bankRepository.updateAccountBalance(toAccount, toAccountBalance + amount);
            }
        }
    }

    public void withdrawMoney(String accountNumber, double amount) {
        if (amount <= 0) {
            throw new MyException("Sisestatud summa peab olema suurem kui 0");
        }
        double balance = bankRepository.getBalance(accountNumber);
        if (balance < amount) {
            throw new MyException("Kontol pole piisavalt raha");
        }
        bankRepository.updateAccountBalance(accountNumber, balance - amount);
    }

    public List<Transaction> getTransactionHistory(String accountNumber) {
        return null;
    }

    @Transactional
    public String getName(String accountNumber) {
        Account account =  accountRepository.getAccountByAccountNumber(accountNumber);
        Customer customer = account.getCustomer();
        return customer.getName();
    }
}
