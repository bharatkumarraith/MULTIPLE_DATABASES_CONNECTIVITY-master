package com.solix.jdp.MULTIPLE_DATABASES_CONNECTIVITY.secondaryRepository;

import com.solix.jdp.MULTIPLE_DATABASES_CONNECTIVITY.secondaryDomain.seconduser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface secondRepository extends JpaRepository<seconduser,Integer> {
}
