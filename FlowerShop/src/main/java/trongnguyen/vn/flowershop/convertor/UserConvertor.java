package trongnguyen.vn.flowershop.convertor;

import trongnguyen.vn.flowershop.domain.UserModel;
import trongnguyen.vn.flowershop.entity.UserEntity;

public class UserConvertor {
    public static UserEntity toEntity(UserModel userModel) {
        UserEntity entity = new UserEntity();
        entity.setUsername(userModel.getUsername());
        entity.setPassword(userModel.getPassword());
        entity.setRole("ROLE_USER");
        return entity;
    }
}
