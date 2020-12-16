package ee.bcs.java.demo.tasks.service;

import ee.bcs.java.demo.tasks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUse(String userName, String rawPassword){
        String encodedPassword = passwordEncoder.encode(rawPassword);
        userRepository.createUser(userName, encodedPassword);
    }
}
