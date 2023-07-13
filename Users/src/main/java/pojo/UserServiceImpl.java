package pojo;

import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create User");
        System.out.println("Enter ID: ");
        long id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        User user = new User(id, name, age);
        userRepository.createUser(user);
        System.out.println("User created successfully.");
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void getAllUsers() {
        System.out.println("List of Users:");
        userRepository.getAllUsers();
    }

    @Override
    public void updateUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Update User");
        System.out.print("Enter user ID: ");
        Long userId = scanner.nextLong();
        scanner.nextLine();

        User user = userRepository.getUserById(userId);
        if (user != null) {
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new age: ");
            int newAge = scanner.nextInt();

            user.setName(newName);
            user.setAge(newAge);
            userRepository.updateUser(user);

            System.out.println("User updated successfully.");
        } else {
            System.out.println("User not found.");
        }
        userRepository.updateUser(user);
    }

    @Override
    public void deleteUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Delete User");
        System.out.print("Enter user ID: ");
        Long userId = scanner.nextLong();
        scanner.nextLine();

        boolean deleted = userRepository.deleteUser(userId);
        if (deleted) {
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found.");
        }
    }
}
