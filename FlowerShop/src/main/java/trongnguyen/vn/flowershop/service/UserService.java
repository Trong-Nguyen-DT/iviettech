package trongnguyen.vn.flowershop.service;

import trongnguyen.vn.flowershop.domain.UserModel;
import trongnguyen.vn.flowershop.exception.FieldMissMatchException;

public interface UserService {
    void register(UserModel userModel) throws FieldMissMatchException;
}
