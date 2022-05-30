package nl.novi.backend.techiteasy.Controllers;


import nl.novi.backend.techiteasy.Dtos.CreateUserDTO;
import nl.novi.backend.techiteasy.Dtos.UserCreatedDTO;
import nl.novi.backend.techiteasy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<UserCreatedDTO> createUser(
            @RequestBody CreateUserDTO createUserDTO){

        final UserCreatedDTO createdUser =
                userService.createUser(createUserDTO);

        final URI location = URI.create("/users" + createdUser.getId());
        return ResponseEntity
                .created(location)
                .body(createdUser);


    }

}
