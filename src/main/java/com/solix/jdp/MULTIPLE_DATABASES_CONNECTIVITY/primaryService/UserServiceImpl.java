package com.solix.jdp.MULTIPLE_DATABASES_CONNECTIVITY.primaryService;

import com.solix.jdp.MULTIPLE_DATABASES_CONNECTIVITY.primaryDomain.User;
import com.solix.jdp.MULTIPLE_DATABASES_CONNECTIVITY.primaryRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User getUserByName(String name) {
        return this.userRepository.findByName(name);
    }
}
