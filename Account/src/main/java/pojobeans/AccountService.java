package pojobeans;

public interface AccountService {
    void createAccount(Account account);
    void transferMoney(long fromAccountId, long toAccountId, double amount);
    void depositMoney(long accountId, double amount) throws Exception;
    Account getAccount(long accountId);

}
