package annotationbaseconfiguration;

import Validator.AccountAgeValidator;
import Validator.AccountBalanceValidator;
import Validator.AccountPasswordValidator;
import Validator.AccountValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "annotationbaseconfiguration")
public class BeanConfig {
    @Bean
    public List<AccountValidator> validators() {
        List<AccountValidator> validators = new ArrayList<>();
        validators.add(new AccountAgeValidator());
        validators.add(new AccountBalanceValidator());
        validators.add(new AccountPasswordValidator());
        return validators;
    }
}
