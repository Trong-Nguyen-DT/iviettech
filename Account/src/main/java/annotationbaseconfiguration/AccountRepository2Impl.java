package annotationbaseconfiguration;

import org.springframework.stereotype.Repository;
import pojobeans.Account;
import pojobeans.AccountRepository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountRepository2Impl implements AccountRepository {

    private Map<Long, Account> accountMap;

    @PostConstruct
    public void initData () {
        accountMap = new HashMap<Long, Account>();
        Account account1 = new Account();
        account1.setId(1L);
        account1.setOwenName("John");
        account1.setBalance(10.0);

        Account account2 = new Account();
        account2.setId(2L);
        account2.setOwenName("Mary");
        account2.setBalance(20.0);

        accountMap.put(account1.getId(),account1);
        accountMap.put(account2.getId(),account2);
    }


    @Override
    public void createAccount(Account account) {
        System.out.println("đã create thành công");
    }

    @Override
    public void insert(Account account) {
        accountMap.put(account.getId(), account);
    }

    @Override
    public void update(Account account) {
        accountMap.put(account.getId(), account);
    }

    @Override
    public Account find(long accountId) {
        return accountMap.get(accountId);
    }
}
