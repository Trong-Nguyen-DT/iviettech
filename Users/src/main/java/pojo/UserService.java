package pojo;

import java.util.List;

public interface UserService {
    void createUser();
    User getUserById(Long id);
    void getAllUsers();
    void updateUser();
    void deleteUser();
}
