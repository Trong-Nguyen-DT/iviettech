package pojo;

public interface UserRepository {
    void createUser(User user);
    User getUserById(Long id);
    void getAllUsers();
    void updateUser(User user);
    boolean deleteUser(Long id);

}
