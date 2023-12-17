package com.solix.jdp.MULTIPLE_DATABASES_CONNECTIVITY.primaryRepository;

import com.solix.jdp.MULTIPLE_DATABASES_CONNECTIVITY.primaryDomain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByName(String name);
}
