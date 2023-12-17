package com.solix.jdp.MULTIPLE_DATABASES_CONNECTIVITY.primaryService;

import com.solix.jdp.MULTIPLE_DATABASES_CONNECTIVITY.secondaryDomain.seconduser;
import com.solix.jdp.MULTIPLE_DATABASES_CONNECTIVITY.secondaryRepository.secondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class secondServiceImpl implements secondService{


@Autowired
private secondRepository secondRepository;
    @Override
    public seconduser saveUser(seconduser user) {
        return secondRepository.save(user);
    }

}
