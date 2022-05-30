package nl.novi.backend.techiteasy.Controllers;


import nl.novi.backend.techiteasy.Dtos.RemoteControllerDto;
import nl.novi.backend.techiteasy.Models.RemoteController;
import nl.novi.backend.techiteasy.Service.RemoteControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.Remote;
import java.util.List;

@RestController
public class RemoteControllerController {

    private final RemoteControllerService remoteControllerService;

@Autowired
public RemoteControllerController(RemoteControllerService remoteControllerService) {
    this.remoteControllerService = remoteControllerService;
}

@GetMapping("/remotecontrollers")
    public List<RemoteControllerDto> getAllRemoteControllers(){

    List<RemoteController> dtos = RemoteControllerService.getAllRemoteControllers();

    return dtos;

}

@GetMapping("/remotecontrollers/{id}")
    public RemoteControllerDto getallRemoteController(@PathVariable("id") Long id) {

    RemoteControllerDto remoteControllerDto = remoteControllerService.getRemoteController(id);

    return remoteControllerDto;

}

@PostMapping("/remotecontrollers")
    public RemoteControllerDto addRemoteController(@RequestBody RemoteControllerDto dto) {
    RemoteControllerDto remotecontrollerDto = remoteControllerService.addRemoteController(dto);
    return dto1;

}

@DeleteMapping("/remotecontroller/{id}")
    public void deleteRemoteController(@PathVariable("id") Long id){remoteControllerService.deleteRemoteController(id);}


@PutMapping("/remotecontroller/{id}")
    public RemoteControllerDto updateRemoteController(@PathVariable("id") Long id, @RequestBody RemoteControllerDto dto) {
    remoteControllerService.updateRemoteController(id, dto);
    return dto;
}

}
