package javabasedconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pojo.UserRepository;
import pojo.UserRepositoryImpl;
import pojo.UserService;
import pojo.UserServiceImpl;

@Configuration
public class BeanConfiguration {
    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryImpl();
    }

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }
}
