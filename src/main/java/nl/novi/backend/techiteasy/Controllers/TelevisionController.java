package nl.novi.backend.techiteasy.Controllers;

import nl.novi.backend.techiteasy.Models.Television;
import nl.novi.backend.techiteasy.Repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TelevisionController {


private TelevisionRepository televisionRepository;

    @Autowired
    public TelevisionController (TelevisionRepository televisionRepository){
        this.televisionRepository = televisionRepository;
    }

    @GetMapping("/televisions")
    public ResponseEntity<List<Television>> getAllTelevisions() {
        televisionRepository.findAll();
        return ResponseEntity.ok().body(televisionRepository.findAll());
    }

    @GetMapping("/televisions/{id})")
    public ResponseEntity<Television> getTelevision(@PathVariable long id)
    {televisionRepository.findById(id);
        return ResponseEntity.ok().body(televisionRepository.findById(id).get());
   }

  @PostMapping("/televisions")
    public ResponseEntity<Television> addTelevision(@RequestBody Television newTelevision) {
      televisionRepository.save(newTelevision);
       return ResponseEntity.created(location).build();
   }

   @DeleteMapping("/television/{id}")
    public ResponseEntity<Television> deleteTelevision(@PathVariable Long id) {

      televisionRepository.deleteById(id);
  }

  @PutMapping("/televisions/{id}")
  public ResponseEntity<Television> updateTelevision(@PathVariable int id, @RequestBody String television) {

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/television?branch={branch}")
    public ResponseEntity<Television> getAllTelevisions(@RequestParam String branch)

    {
        return ResponseEntity.ok();
    }
}
