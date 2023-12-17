package com.solix.jdp.MULTIPLE_DATABASES_CONNECTIVITY.primaryController;

import com.solix.jdp.MULTIPLE_DATABASES_CONNECTIVITY.primaryDomain.User;
import com.solix.jdp.MULTIPLE_DATABASES_CONNECTIVITY.secondaryDomain.seconduser;
import com.solix.jdp.MULTIPLE_DATABASES_CONNECTIVITY.primaryService.UserService;
import com.solix.jdp.MULTIPLE_DATABASES_CONNECTIVITY.primaryService.secondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @Autowired
    private secondService secondService;
    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        // Save to the first database
        this.userService.saveUser(user);

        // Save to the second database
        seconduser secondaryUser = new seconduser();
        secondaryUser.setId(user.getId());
        secondaryUser.setName(user.getName());
        secondaryUser.setEmail(user.getEmail());
        this.secondService.saveUser(secondaryUser);

        return new ResponseEntity<>("Users saved successfully", HttpStatus.OK);
    }


}
