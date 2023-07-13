package pojo;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository{

    private Map<Long, User> userMap = new HashMap<>();

    @Override
     public void createUser(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public User getUserById(Long id) {
        return userMap.get(id);
    }


    @Override
    public void getAllUsers() {
        for (Map.Entry<Long, User> entry : userMap.entrySet()){
            System.out.println(entry.getValue().getId() + " | " + entry.getValue().getName() + " | " + entry.getValue().getAge());
        }
    }

    @Override
    public void updateUser(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public boolean deleteUser(Long id) {
        userMap.remove(id);
        return false;
    }
}
