package com.solix.jdp.MULTIPLE_DATABASES_CONNECTIVITY.primaryService;

import com.solix.jdp.MULTIPLE_DATABASES_CONNECTIVITY.primaryDomain.User;

public interface UserService {

    User saveUser(User user);

    User getUserByName(String name);

}
