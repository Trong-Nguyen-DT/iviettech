package xmlbasedconfiguration;

import pojobeans.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        System.out.println("Before money transfer");
        System.out.println("Account 1 balance : " + accountService.getAccount(1).getBalance());
        System.out.println("Account 2 balance : " + accountService.getAccount(2).getBalance());

        accountService.transferMoney(1, 2, 5.0);
        System.out.println("===============================================================");
        System.out.println("After money transfer");
        System.out.println("Account 1 balance : " + accountService.getAccount(1).getBalance());
        System.out.println("Account 2 balance : " + accountService.getAccount(2).getBalance());
    }
}
