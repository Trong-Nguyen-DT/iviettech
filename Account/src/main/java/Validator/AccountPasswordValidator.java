package Validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pojobeans.Account;

@Component
public class AccountPasswordValidator implements AccountValidator {
    @Override
    public void validate(Account account) {
        if (StringUtils.isEmpty(account.getPassword())) {
            throw new IllegalArgumentException("Password is empty");
        }

        if (account.getPassword().length() <= 8 || account.getPassword().length() >= 16) {
            throw new IllegalArgumentException("Password nằm trong khoảng 8-16 ký tự");
        }
    }
}
