package Validator;

import org.springframework.stereotype.Component;
import pojobeans.Account;

@Component
public class AccountBalanceValidator implements AccountValidator {

    @Override
    public void validate(Account account) {
        if (account.getBalance() <= 100) {
            throw new IllegalArgumentException("Account Balance phải lớn hơn 100 củ");
        }
    }
}
