package nl.novi.backend.techiteasy.Service;

import nl.novi.backend.techiteasy.Dtos.CreateUserDTO;
import nl.novi.backend.techiteasy.Dtos.UserCreatedDTO;
import nl.novi.backend.techiteasy.Repositories.UserRepository;
import nl.novi.backend.techiteasy.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserCreatedDTO createUser(CreateUserDTO createUserDTO) {
        final User newUser = new User();
        newUser.setUserName(createUserDTO.getUserName());
        newUser.getPassword(createUserDTO.getPassword());

        final User savedUser = userRepository.save(newUser);

        final UserCreatedDTO userCreatedDTO = new UserCreatedDTO();
        userCreatedDTO.setId(savedUser.getId());
        userCreatedDTO.setUserName(savedUser.getUserName());

        return userCreatedDTO;
    }

//
//
//
//
//
//
//
//
//        @Autowired
//        private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//
//    public String createUser(UserRequestDto userRequestDto) {
//            String encryptedPassword = passwordEncoder.encode(userRequestDto.getPassword());
//
//
//            User user = new User();
//
//
//            user.setUsername(userRequestDto.getUsername());
//            user.setPassword(encryptedPassword);
//            user.setEmail(userRequestDto.getEmail());
//            user.setEnabled(true);
//            user.addAuthority("ROLE_USER");
//
//
//            User savedUser = userRepository.save(user);
//
//
//            return savedUser.getUsername();
//        }
//


    }


