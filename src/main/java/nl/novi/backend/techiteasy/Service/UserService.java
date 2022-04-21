package nl.novi.backend.techiteasy.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class UserService {

    @Service
    public class UserService {


        @Autowired
        private UserRepository userRepository;


        @Autowired
        private PasswordEncoder passwordEncoder;


        public String createUser(UserRequestDto userRequestDto) {
            String encryptedPassword = passwordEncoder.encode(userRequestDto.getPassword());


            User user = new User();


            user.setUsername(userRequestDto.getUsername());
            user.setPassword(encryptedPassword);
            user.setEmail(userRequestDto.getEmail());
            user.setEnabled(true);
            user.addAuthority("ROLE_USER");


            User savedUser = userRepository.save(user);


            return savedUser.getUsername();
        }



    }

}
