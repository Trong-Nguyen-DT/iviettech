package trongnguyen.vn.flowershop.validator;

import org.springframework.stereotype.Component;
import trongnguyen.vn.flowershop.domain.UserModel;
import trongnguyen.vn.flowershop.exception.FieldMissMatchException;

import java.util.Objects;

@Component
public class UserRegisterValidator {
    public void validateRegisterUser(UserModel userModel)
            throws FieldMissMatchException {

        if (!Objects.equals(userModel.getPassword(), userModel.getRePassword())) {
            throw new FieldMissMatchException("Password miss match");
        }
    }
}
