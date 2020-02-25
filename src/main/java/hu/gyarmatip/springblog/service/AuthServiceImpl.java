package hu.gyarmatip.springblog.service;

import hu.gyarmatip.springblog.dto.RegisterRequest;
import hu.gyarmatip.springblog.entity.User;
import hu.gyarmatip.springblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User signUp(RegisterRequest registerRequest) {
        User user = new User();
        user.setUserName(registerRequest.getUsername());

        String rawPassword = registerRequest.getPassword();
        user.setPassword(encodePassword(rawPassword));

        user.setEmail(registerRequest.getEmail());
        return userRepository.save(user);
    }

    @Override
    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }
}
