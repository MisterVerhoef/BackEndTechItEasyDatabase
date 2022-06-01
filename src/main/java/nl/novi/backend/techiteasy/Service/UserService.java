package nl.novi.backend.techiteasy.Service;

import nl.novi.backend.techiteasy.Dtos.UserDto;
import nl.novi.backend.techiteasy.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

        /*autowire de juiste repository*/

        public List<UserDto> getUsers() {
            List<UserDto> collection = new ArrayList<>();
            List<User> list = /*repo*/.findAll();
            for (User user : list) {
                collection.add(fromUser(user));
            }
            return collection;
        }

        public UserDto getUser(String username) {
            UserDto dto = new UserDto();
            Optional<User> user = /*repo*/.findById(username);
            if (user.isPresent()){
                dto = fromUser(user.get());
            }else {
                throw new /*exception*/(username);
            }
            return dto;
        }

        public boolean userExists(String username) {
            return /*repo*/.existsById(username);
        }

        public String createUser(UserDto userDto) {
            String randomString = RandomStringGenerator.generateAlphaNumeric(20);
            userDto.setApikey(randomString);
            User newUser = /*repo*/.save(toUser(userDto));
            return newUser.getUsername();
        }

        public void deleteUser(String username) {
            /*repo*/.deleteById(username);
        }

        public void updateUser(String username, UserDto newUser) {
            if (!userRepository.existsById(username)) throw new /*exception*/();
            User user = /*repo*/.findById(username).get();
            user.setPassword(newUser.getPassword());
            /*repo*/.save(user);
        }

        public Set<Authority> getAuthorities(String username) {
            if (!/*repo*/.existsById(username)) throw new /*exception*/(username);
            User user = /*repo*/.findById(username).get();
            UserDto userDto = fromUser(user);
            return userDto.getAuthorities();
        }

        public void addAuthority(String username, String authority) {

            if (!/*repo*/.existsById(username)) throw new /*exception*/(username);
            User user = /*repo*/.findById(username).get();
            user.addAuthority(new Authority(username, authority));
            /*repo*/.save(user);
        }

        public void removeAuthority(String username, String authority) {
            if (!/*repo*/.existsById(username)) throw new /*exception*/(username);
            User user = /*repo*/.findById(username).get();
            Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
            user.removeAuthority(authorityToRemove);
            /*repo*/.save(user);
        }

        public static UserDto fromUser(User user){

            var dto = new UserDto();

            dto.username = user.getUsername();
            dto.password = user.getPassword();
            dto.enabled = user.isEnabled();
            dto.apikey = user.getApikey();
            dto.email = user.getEmail();
            dto.authorities = user.getAuthorities();

            return dto;
        }

        public User toUser(UserDto userDto) {

            var user = new User();

            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            user.setEnabled(userDto.getEnabled());
            user.setApikey(userDto.getApikey());
            user.setEmail(userDto.getEmail());

            return user;
        }

    }


