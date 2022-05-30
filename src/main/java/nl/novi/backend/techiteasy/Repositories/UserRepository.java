package nl.novi.backend.techiteasy.Repositories;

import nl.novi.backend.techiteasy.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    @Override
//    Optional<User> findUserByUsernameIs();
}
