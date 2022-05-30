package nl.novi.backend.techiteasy.Controllers;

import nl.novi.backend.techiteasy.Dtos.TelevisionDTO;
import nl.novi.backend.techiteasy.Dtos.TelevisionInputDto;
import nl.novi.backend.techiteasy.Exceptions.RecordNotFoundException;
import nl.novi.backend.techiteasy.Models.Television;
import nl.novi.backend.techiteasy.Repositories.TelevisionRepository;
import nl.novi.backend.techiteasy.Service.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TelevisionController {


    private final TelevisionService televisionService;

    @Autowired
    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @GetMapping("/televisions")
    public ResponseEntity<List<TelevisionDTO>> getAllTelevisions(@RequestParam(value = "brand", required = false) Optional<String> brand) {

        List<TelevisionDTO> dtos;

        if (brand.isEmpty()) {

            dtos = televisionService.getAllTelevisions();

        } else {

            dtos = televisionService.getAllTelevisionsByBrand(brand.get());
        }

        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/televisions/{id})")
    public ResponseEntity<TelevisionDTO> getTelevision(@PathVariable("id") long id) {

        TelevisionDTO television = televisionService.getTelevisionById(id);

        return ResponseEntity.ok().body(television);


    }

    @PostMapping("/televisions")
    public ResponseEntity<Object> addTelevision(@RequestBody TelevisionInputDto televisionInputDto) {

        TelevisionDTO dto = televisionService.addTelevision(televisionInputDto);

        return ResponseEntity.created(null).body(dto);
    }

    @DeleteMapping("/television/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable Long id) {

        televisionService.deleteTelevision(id);

        return ResponseEntity.noContent().build();
    }


    @PutMapping("/televisions/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable Long id, @RequestBody TelevisionInputDto newTelevision) {

        TelevisionDTO dto = televisionService.updateTelevision(id, newTelevision);

        return ResponseEntity.ok().body(dto);
    }
}






