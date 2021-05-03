package ee.bcs.java.demo.tasks.lesson1.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Tegelikult seda ei tohi hardcodeda vaid teeme User tabeli ja küsime repository klassiga
        return User.withUsername("test")
                .password(passwordEncoder.encode("test")) // parool andmebaasist
                .roles("ROLE_USER").build();
    }
}
