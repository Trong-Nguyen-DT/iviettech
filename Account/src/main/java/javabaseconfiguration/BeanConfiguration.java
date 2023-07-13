package javabaseconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pojobeans.AccountRepository;
import pojobeans.AccountRepositoryImpl;
import pojobeans.AccountService;
import pojobeans.AccountServiceImpl;

@Configuration
public class BeanConfiguration {
    @Bean
    public AccountService accountService () {
        AccountServiceImpl bean = new AccountServiceImpl();
        bean.setAccountRepository(accountDao());
        return bean;
    }
    @Bean
    public AccountRepository accountDao() {
        AccountRepositoryImpl bean = new AccountRepositoryImpl();
        return bean;
    }
}
