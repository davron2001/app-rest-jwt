package uz.ages.apprestjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MyAuthService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = new ArrayList<>(
                Arrays.asList(
                        new User("ages", passwordEncoder.encode("davr"), new ArrayList<>()),
                        new User("ages1", passwordEncoder.encode("davr1"), new ArrayList<>()),
                        new User("ages2", passwordEncoder.encode("davr2"), new ArrayList<>())
                )
        );
        for (User user : users) {
            if (user.getUsername().equals(username))
                return user;
        }
        throw new UsernameNotFoundException("Username not found.");
    }
}
