package Validator;

import org.springframework.stereotype.Component;
import pojobeans.Account;

@Component
public class AccountAgeValidator implements AccountValidator {

    @Override
    public void validate(Account account) {
        if (account.getAge() <= 18) {
            throw new IllegalArgumentException("Chưa đủ tuổi vào site người lớn");
        }
    }
}
