package ee.bcs.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//@RestController
public class Lesson4Controller {
    Map<String, Integer> accounts = new HashMap<>();

    @GetMapping("bank/createAccount")
    // http://localhost:8080/bank/createAccount?accountNumber=EE123
    public String createAccount(@RequestParam("accountNumber") String accountNumber) {
        accounts.put(accountNumber, 0);
        return "konto " + accountNumber + " on loodud";
    }

    @GetMapping("bank2/createAccount/{accountNumber}")
    // http://localhost:8080/bank2/createAccount/EE123
    public String createAccount2(@PathVariable("accountNumber") String accountNumber) {
        accounts.put(accountNumber, 0);
        return "konto " + accountNumber + " on loodud";
    }


    @GetMapping("bank/getBalance")
    // http://localhost:8080/bank/getBalance?accountNumber=EE123
    public String getBalance(@RequestParam("accountNumber") String accountNumber) {
        Integer balance = accounts.get(accountNumber);
        if (balance == null) {
            return "konto pole loodud";
        } else {
            return "konto jääk on " + balance + " eur";
        }
    }

    @GetMapping("bank2/getBalance/{accountNumber}")
    // http://localhost:8080/bank2/getBalance/EE123
    public String getBalance2(@PathVariable("accountNumber") String accountNumber) {
        Integer balance = accounts.get(accountNumber);
        if (balance == null) {
            return "konto pole loodud";
        } else {
            return "konto jääk on " + balance + " eur";
        }
    }


    @GetMapping("bank/depositMoney")
    // http://localhost:8080/bank/depositMoney?accountNumber=EE123&amount=1600
    public String depositMoney(@RequestParam("accountNumber") String accountNumber, Integer amount) {
        //todo oluline, et amount > 0
        Integer oldBalance = accounts.get(accountNumber);
        if (oldBalance == null) {
            return "konto pole loodud";
        } else {
            if (amount > 0) {
                Integer newBalance = oldBalance + amount;
                accounts.put(accountNumber, newBalance);
                return "kontole lisatud " + amount + " eur. Konto jääk on " + newBalance + " eur";
            } else {
                return "summa peab olema positiivne";
            }
        }
    }


    @GetMapping("bank2/depositMoney/{accountNumber}/{amount}")
    // http://localhost:8080/bank2/depositMoney/EE123/1600
    public String depositMoney2(@PathVariable("accountNumber") String accountNumber, @PathVariable("amount") Integer amount) {
        //todo oluline, et amount > 0
        Integer oldBalance = accounts.get(accountNumber);
        if (oldBalance == null) {
            return "konto pole loodud";
        } else {
            if (amount > 0) {
                Integer newBalance = oldBalance + amount;
                accounts.put(accountNumber, newBalance);
                return "kontole lisatud " + amount + " eur. Konto jääk on " + newBalance + " eur";
            } else {
                return "summa peab olema positiivne";
            }
        }
    }

    @GetMapping("bank/withdrawMoney")
    // http://localhost:8080/bank/withdrawMoney?accountNumber=EE123&amount=200
    public String withdrawMoney(@RequestParam("accountNumber") String accountNumber, @RequestParam("amount") Integer amount) {
        Integer oldBalance = accounts.get(accountNumber);
        if (oldBalance == null) {
            return "konto pole loodud";
        } else {
            if (amount <= oldBalance && amount > 0) {
                Integer newBalance = oldBalance - amount;
                accounts.put(accountNumber, newBalance);
                return "väljastati " + amount + " eur. Konto jääk on " + newBalance + " eur";
            } else if (amount > oldBalance && amount > 0) {
                return "pole piisavalt raha";
            } else if (amount <= oldBalance && amount < 0) {
                return "summa peab olema suurem kui 0";
            } else {
                return "valesti sisestatud andmed";
            }
        }
    }

    @GetMapping("bank2/withdrawMoney/{accountNumber}/{amount}")
    // http://localhost:8080/bank2/withdrawMoney/EE123/200
    public String withdrawMoney2(@PathVariable("accountNumber") String accountNumber, @PathVariable("amount") Integer amount) {
        Integer oldBalance = accounts.get(accountNumber);
        if (oldBalance == null) {
            return "konto pole loodud";
        } else {
            if (amount <= oldBalance && amount > 0) {
                Integer newBalance = oldBalance - amount;
                accounts.put(accountNumber, newBalance);
                return "väljastati " + amount + " eur. Konto jääk on " + newBalance + " eur";
            } else if (amount > oldBalance && amount > 0) {
                return "pole piisavalt raha";
            } else if (amount <= oldBalance && amount < 0) {
                return "summa peab olema suurem kui 0";
            } else {
                return "valesti sisestatud andmed";
            }
        }
    }

    @GetMapping("bank/transferMoney")
    //http://localhost:8080/bank/transferMoney?fromAccountNumber=EE123&toAccountNumber=EE124&amount=1500
    public String transferMoney(@RequestParam("fromAccountNumber") String fromAccountNumber, @RequestParam("toAccountNumber") String toAccountNumber, @RequestParam("amount") Integer amount) {
        Integer oldFromBalance = accounts.get(fromAccountNumber);
        Integer oldToBalance = accounts.get(toAccountNumber);
        Integer newFromBalance = oldFromBalance - amount;
        Integer newToBalance = oldToBalance + amount;
        accounts.put(fromAccountNumber, newFromBalance);
        accounts.put(toAccountNumber, newToBalance);
        if (oldFromBalance == null && oldToBalance == null) {
            return "kontod pole loodud";
        } else {
            if (amount < 0) {
                return "summa peab olema suurem kui 0";
            } else {
                return amount + " eur on üle viidud kontolt " + fromAccountNumber + " kontole " + toAccountNumber + ". " + toAccountNumber + " saldo on " + newToBalance + " eur. " + fromAccountNumber + " saldo on " + newFromBalance + " eur.";

            }
        }
    }


    @GetMapping("bank2/transferMoney/{fromAccountNumber}/{toAccountNumber}/{amount}")
    //http://localhost:8080/bank2/transferMoney/EE123/EE124/1500
    public String transferMoney2(@PathVariable("fromAccountNumber") String fromAccountNumber, @PathVariable("toAccountNumber") String toAccountNumber, @PathVariable("amount") Integer amount) {
        Integer oldFromBalance = accounts.get(fromAccountNumber);
        Integer oldToBalance = accounts.get(toAccountNumber);
        if (oldFromBalance == null && oldToBalance == null) {
            return "kontod pole loodud";
        } else {
            Integer newFromBalance = oldFromBalance - amount;
            Integer newToBalance = oldToBalance + amount;
            if (amount < 0) {
                return "summa peab olema suurem kui 0";
            } else {
                accounts.put(fromAccountNumber, newFromBalance);
                accounts.put(toAccountNumber, newToBalance);
                return amount + " eur on üle viidud kontolt " + fromAccountNumber + " kontole " + toAccountNumber + ". " + toAccountNumber + " saldo on " + newToBalance + " eur. " + fromAccountNumber + " saldo on " + newFromBalance + " eur.";

            }
        }
    }

}
