package annotationbaseconfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pojobeans.Account;
import pojobeans.AccountService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);

        Account account = new Account();
        account.setAge(19);
        account.setBalance(101);
        account.setPassword("123456789");


        accountService.createAccount(account);
    }
}
