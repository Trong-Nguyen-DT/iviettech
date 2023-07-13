package javabasedconfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pojo.User;
import pojo.UserService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private UserService userService;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        UserService userService = context.getBean(UserService.class);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Create User");
            System.out.println("2. List User");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    userService.createUser();
                    break;
                case 2:
                    userService.getAllUsers();
                    break;
                case 3:
                    userService.updateUser();
                    break;
                case 4:
                    userService.deleteUser();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
