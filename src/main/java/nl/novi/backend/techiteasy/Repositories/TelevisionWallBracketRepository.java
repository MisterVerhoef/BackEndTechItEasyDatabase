package nl.novi.backend.techiteasy.Repositories;

import nl.novi.backend.techiteasy.Models.TelevisionWallBracket;
import nl.novi.backend.techiteasy.Models.TelevisionWallBracketKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TelevisionWallBracketRepository extends JpaRepository<TelevisionWallBracket, TelevisionWallBracketKey> {
    Collection<TelevisionWallBracket> findAllByTelevisionId(Long televisionId);
    Collection<TelevisionWallBracket> findAllByWallBracketId(Long wallBracketId);
}