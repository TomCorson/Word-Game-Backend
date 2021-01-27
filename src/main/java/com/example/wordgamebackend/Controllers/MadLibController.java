package com.example.wordgamebackend.Controllers;

import com.example.wordgamebackend.Entities.MadLib;
import com.example.wordgamebackend.Services.MadLibService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MadLibController {
    @Autowired
    MadLibService madLibService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getMadLib(@PathVariable Long id){
        log.info("Get MadLib by id called in controller");
        return madLibService.getMadLib(id);
    }

    @PostMapping
    public ResponseEntity<?> createMadLib(@RequestBody MadLib madLib){
        log.info("Create MadLib called from controller");
        madLibService.createMadLib(madLib);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public Boolean deleteMadLib(@PathVariable Long id){
        log.info("delete called from controller");
        return madLibService.deleteMadLib(id);
    }

}
