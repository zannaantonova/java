package ee.bcs.java.demo.tasks.lesson1.sample.bank;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account getAccountByAccountNumber(String accountNumber);
}
