package pojobeans;

public interface AccountRepository {
    void createAccount(Account account);
    void insert(Account account);
    void update(Account account);
    Account find (long accountId);


}
