package nl.novi.backend.techiteasy.Service;

import nl.novi.backend.techiteasy.Dtos.TelevisionDTO;
import nl.novi.backend.techiteasy.Dtos.TelevisionInputDto;
import nl.novi.backend.techiteasy.Exceptions.RecordNotFoundException;
import nl.novi.backend.techiteasy.Models.Television;
import nl.novi.backend.techiteasy.Repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionService {


    private final TelevisionRepository televisionRepository;


    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<TelevisionDTO> getAllTelevisions() {

        List<Television> tvList = televisionRepository.findAll();
        List<TelevisionDTO> tvDtoList = new ArrayList<>();

        for (Television tv : tvList) {
            TelevisionDTO dto = transferToDto(tv);
            tvDtoList.add(dto);
        }
        return tvDtoList;


    }


    public List<TelevisionDTO> getAllTelevisionsByBrand(String brand) {
        List<Television> tvList = televisionRepository.findAllTelevisionByBrandEqualsIgnoreCase(brand);
        List<TelevisionDTO> tvDtoList = new ArrayList<>();

        for (Television tv : tvList) {
            TelevisionDTO dto = transferToDto(tv);
            tvDtoList.add(dto);
        }

        return tvDtoList;

    }


    public TelevisionDTO getTelevisionById(Long id) {

        if (televisionRepository.findById(id).isPresent()) {
            Television tv = televisionRepository.findById(id).get();
            return transferToDto(tv);
        } else {
            throw new RecordNotFoundException("geen televisie gevonden");
        }
    }

    public TelevisionDTO addTelevision(TelevisionInputDto dto) {

        Television tv = transferToTelevision(dto);
        televisionRepository.save(tv);

        return transferToDto(tv);
    }


    public void deleteTelevision(@RequestBody Long id) {

        televisionRepository.deleteById(id);

    }


    public TelevisionDTO updateTelevision(Long id, TelevisionInputDto inputDto) {

        if (televisionRepository.findById(id).isPresent()) {

            Television tv = televisionRepository.findById(id).get();

            Television tv1 = transferToTelevision(inputDto);
            tv1.setId(tv.getId());

            televisionRepository.save(tv1);

            return transferToDto(tv1);

        } else {

            throw new RecordNotFoundException("Cannot find television");
        }
    }

    public Television transferToTelevision(TelevisionInputDto dto){
        var television = new Television();

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

        return television;

    }

public TelevisionDTO transferToDto(Television television){
        TelevisionDTO dto = new TelevisionDTO();

    dto.setId(television.getId());
    dto.setType(television.getType());
    dto.setBrand(television.getBrand());
    dto.setName(television.getName());
    dto.setPrice(television.getPrice());
    dto.setAvailableSize(television.getAvailableSize());
    dto.setRefreshRate(television.getRefreshRate());
    dto.setScreenType(television.getScreenType());
    dto.setScreenQuality(television.getScreenQuality());
    dto.setSmartTv(television.getWifi());
    dto.setWifi(television.getWifi());
    dto.setVoiceControl(television.getVoiceControl());
    dto.setHdr(television.getHdr());
    dto.setBluetooth(television.getBluetooth());
    dto.setAmbiLight(television.getAmbiLight());
    dto.setOriginalStock(television.getOriginalStock());
    dto.setSold(television.getSold());

    return dto;

}


}

