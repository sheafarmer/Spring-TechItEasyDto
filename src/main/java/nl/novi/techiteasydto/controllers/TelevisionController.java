package nl.novi.techiteasydto.controllers;

import nl.novi.techiteasydto.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "televisions")
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    // DTO

    @GetMapping("/dto")
    public ResponseEntity<List<ResponseTelevisionDto>> getTelevisionsDto(){
        return ResponseEntity.ok(televisionService.getTelevisionsDto());
    }

    @GetMapping("dto/{id}")
    public ResponseEntity <ResponseTelevisionDto> getTelevisionDto(@PathVariable Long id) {
        ResponseTelevisionDto television = televisionService.getTelevisionDto(id);
        return ResponseEntity.ok(television);
    }

    @PostMapping
    public ResponseEntity <Void> saveTelevisionDto(@RequestBody RequestTelevisionDto television) {
        televisionService.saveTelevisionDto(television);
        return ResponseEntity.created(null).build();
    }
}
