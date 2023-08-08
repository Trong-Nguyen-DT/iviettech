package trongnguyen.vn.flowershop.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import trongnguyen.vn.flowershop.convertor.UserConvertor;
import trongnguyen.vn.flowershop.domain.UserModel;
import trongnguyen.vn.flowershop.entity.UserEntity;
import trongnguyen.vn.flowershop.exception.FieldMissMatchException;
import trongnguyen.vn.flowershop.repository.UserRepository;
import trongnguyen.vn.flowershop.service.UserService;
import trongnguyen.vn.flowershop.validator.UserRegisterValidator;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRegisterValidator validator;
    @Transactional
    @Override
    public void register(UserModel userModel) throws FieldMissMatchException {
        validator.validateRegisterUser(userModel);
        UserEntity entity = UserConvertor.toEntity(userModel);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        repository.save(entity);
    }
}
