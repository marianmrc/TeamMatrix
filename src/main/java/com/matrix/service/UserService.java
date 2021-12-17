package com.matrix.service;

import com.matrix.exception.NonUniqueCnpException;
import com.matrix.exception.NonUniqueEmailException;
import com.matrix.model.User;
import com.matrix.repository.UserRepository;
import com.matrix.security.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Objects;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String email, String password) {
        for (User user : userRepository.findAll()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public void createUser(@Valid User user) throws NonUniqueEmailException, NonUniqueCnpException {
        if (emailAlreadyExists(user.getEmail(), user.getUserId())) {
            throw new NonUniqueEmailException("Acest email este deja folosit");
        }
        if (cnpAlreadyExists(user.getCnp())) {
            throw new NonUniqueCnpException("Acest cnp este deja utilizat");
        }
        userRepository.save(user);
    }

    public boolean emailAlreadyExists(String email, Long id) {
        User user = userRepository.findUserByEmail(email);
        return user != null && !Objects.equals(user.getUserId(), id);
    }

    public boolean cnpAlreadyExists(String cnp) {
        User user = userRepository.findUserByCnp(cnp);
        return user != null;
    }
}
