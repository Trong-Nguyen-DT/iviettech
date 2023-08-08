package trongnguyen.vn.flowershop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import trongnguyen.vn.flowershop.entity.UserEntity;
import trongnguyen.vn.flowershop.repository.UserRepository;
import trongnguyen.vn.flowershop.security.UserPrincipal;

import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity entity = userRepository.findByUsername(username)
                .orElseThrow(() -> new BadCredentialsException("Không tìm thấy user"));

        UserPrincipal principal = new UserPrincipal();
        principal.setId(entity.getId());
        principal.setUsername(username);
        principal.setPassword(entity.getPassword());
        principal.setAuthorities(List.of(new SimpleGrantedAuthority(entity.getRole())));
        return principal;
    }
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("123123"));
    }
}
