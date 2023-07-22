package vn.iviettech.springbookmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.iviettech.springbookmvc.converter.UserConverter;
import vn.iviettech.springbookmvc.domain.User;
import vn.iviettech.springbookmvc.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public Long createUser(User user) {
        return userRepository.save(UserConverter.toEntity(user)).getId();
    }
}
