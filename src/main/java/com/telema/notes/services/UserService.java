package com.telema.notes.services;

import com.telema.notes.entities.User;
import com.telema.notes.exceptions.DuplicateEmailException;
import com.telema.notes.exceptions.NoDataFoundException;
import com.telema.notes.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) throw new DuplicateEmailException();
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if (optionalUser.isEmpty()) {
            throw new NoDataFoundException();
        }
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        Optional<User> optionalUsers = userRepository.findById(id);
        if (optionalUsers.isEmpty()) {
            throw new NoDataFoundException();
        }

        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(NoDataFoundException::new);
    }
}
