package nl.novi.backend.techiteasy.Service;

import nl.novi.backend.techiteasy.Dtos.TelevisionDTO;
import nl.novi.backend.techiteasy.Dtos.WallBracketDto;
import nl.novi.backend.techiteasy.Exceptions.RecordNotFoundException;
import nl.novi.backend.techiteasy.Models.Television;
import nl.novi.backend.techiteasy.Models.TelevisionWallBracket;
import nl.novi.backend.techiteasy.Models.TelevisionWallBracketKey;
import nl.novi.backend.techiteasy.Models.WallBracket;
import nl.novi.backend.techiteasy.Repositories.TelevisionRepository;
import nl.novi.backend.techiteasy.Repositories.TelevisionWallBracketRepository;
import nl.novi.backend.techiteasy.Repositories.WallBracketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class TelevisionWallBracketService{

    @Autowired
    private TelevisionRepository televisionRepository;

    @Autowired
    private WallBracketRepository wallBracketRepository;

    @Autowired
    private TelevisionWallBracketRepository televisionWallBracketRepository;

    public Collection<TelevisionDTO> getTelevisionWallBracketsByWallBracketId(Long wallBracketId) {
        Collection<TelevisionDTO> dtos = new HashSet<>();
        Collection<TelevisionWallBracket> televisionWallbrackets = televisionWallBracketRepository.findAllByWallBracketId(wallBracketId);
        for (TelevisionWallBracket televisionWallbracket : televisionWallbrackets) {
            Television television = televisionWallbracket.getTelevision();
            TelevisionDTO dto = new TelevisionDTO();

            television.setId(dto.getId());
            television.setType(dto.getType());
            television.setBrand(dto.getBrand());
            television.setName(dto.getName());
            television.setPrice(dto.getPrice());
            television.setAvailableSize(dto.getAvailableSize());
            television.setRefreshRate(dto.getRefreshRate());
            television.setScreenType(dto.getScreenType());
            television.setScreenQuality(dto.getScreenQuality());
            television.setSmartTv(dto.getSmartTv());
            television.setWifi(dto.getWifi());
            television.setVoiceControl(dto.getVoiceControl());
            television.setHdr(dto.getHdr());
            television.setBluetooth(dto.getBluetooth());
            television.setAmbiLight(dto.getAmbiLight());
            television.setOriginalStock(dto.getOriginalStock());
            television.setSold(dto.getSold());

            dtos.add(dto);
        }
        return dtos;
    }

    public Collection<WallBracketDto> getTelevisionWallBracketByTelevisionId(Long televisionId) {
        Collection<WallBracketDto> dtos = new HashSet<>();
        Collection<TelevisionWallBracket> televisionWallbrackets = televisionWallBracketRepository.findAllByTelevisionId(televisionId);
        for (TelevisionWallBracket televisionWallbracket : televisionWallbrackets) {
            WallBracket wallBracket = televisionWallbracket.getWallBracket();
            var dto = new WallBracketDto();

            dto.setId(wallBracket.getId());
            dto.setName(wallBracket.getName());
            dto.setSize(wallBracket.getSize());
            dto.setAdjustable(wallBracket.getAdjustable());
            dto.setPrice(wallBracket.getPrice());

            dtos.add(dto);
        }
        return dtos;
    }


    public TelevisionWallBracketKey addTelevisionWallBracket(Long televisionId, Long wallBracketId) {
        var televisionWallBracket = new TelevisionWallBracket();
        if (!televisionRepository.existsById(televisionId)) {throw new RecordNotFoundException();}
        Television television = televisionRepository.findById(televisionId).orElse(null);
        if (!wallBracketRepository.existsById(wallBracketId)) {throw new RecordNotFoundException();}
        WallBracket wallBracket = wallBracketRepository.findById(wallBracketId).orElse(null);
        televisionWallBracket.setTelevision(television);
        televisionWallBracket.setWallBracket(wallBracket);
        TelevisionWallBracketKey id = new TelevisionWallBracketKey(televisionId, wallBracketId);
        televisionWallBracket.setId(id);
        televisionWallBracketRepository.save(televisionWallBracket);
        return id;
    }
}
