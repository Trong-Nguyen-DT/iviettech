package annotationbaseconfiguration;

import Validator.AccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojobeans.Account;
import pojobeans.AccountRepository;
import pojobeans.AccountService;

import java.util.List;


@Service("accountService")
public class AccountService2Impl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private List<AccountValidator> validators;

    @Override
    public void createAccount(Account account) {
        validate(account);
        accountRepository.createAccount(account);
    }

    private void validate(final Account account) {
        validators.forEach(validator -> validator.validate(account));
    }

    @Override
    public void transferMoney(long fromAccountId, long toAccountId, double amount) {
        Account sourceAccount = accountRepository.find(fromAccountId);
        Account targetAccount = accountRepository.find(toAccountId);
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance() + amount);
        accountRepository.update(sourceAccount);
        accountRepository.update(targetAccount);
    }



    @Override
    public void depositMoney(long accountId, double amount) throws Exception {
        Account account = accountRepository.find(accountId);
        account.setBalance(account.getBalance() + amount);
        accountRepository.update(account);
    }

    @Override
    public Account getAccount(long accountId) {
        return accountRepository.find(accountId);
    }
}
