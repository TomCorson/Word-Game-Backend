package com.example.wordgamebackend.Services;

import com.example.wordgamebackend.Entities.MadLib;
import com.example.wordgamebackend.Repos.MadLibRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MadLibService {
    @Autowired
    MadLibRepo madLibRepo;

    public void createMadLib(MadLib madLib) {
        log.info("Create MadLib called from service");
        madLibRepo.save(madLib);
    }

    public ResponseEntity<?> getMadLib(Long id) {
        log.info("Create MadLib called from service");
        return new ResponseEntity<>(madLibRepo.findById(id), HttpStatus.OK);
    }

    public Boolean deleteMadLib(Long id) {
        log.info("delete called from service");
        madLibRepo.deleteById(id);
        return true;
    }
}
