package nl.novi.backend.techiteasy.Repositories;

import nl.novi.backend.techiteasy.Models.Television;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TelevisionRepository extends JpaRepository <Television, Long> {
    List<Television> findAllTelevisionByBrandEqualsIgnoreCase(String Brand);



}
