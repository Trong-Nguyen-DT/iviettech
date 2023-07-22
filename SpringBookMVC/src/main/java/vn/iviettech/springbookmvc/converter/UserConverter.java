package vn.iviettech.springbookmvc.converter;

import vn.iviettech.springbookmvc.domain.User;
import vn.iviettech.springbookmvc.entity.UserEntity;

public class UserConverter {
    public static UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setName(user.getName());
        entity.setAge(user.getAge());
        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        return entity;
    }
}
