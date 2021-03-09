package com.example.wordgamebackend.Services;

import com.example.wordgamebackend.Entities.MadLib;
import com.example.wordgamebackend.Repos.MadLibRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MadLibService {
    @Autowired
    MadLibRepo madLibRepo;

    public void createMadLib(MadLib madLib) {
        log.info("Create MadLib called from service");
        madLibRepo.save(madLib);
    }

    public Optional<MadLib> getMadLib(Long id) {
        log.info("Get MadLib by id called from service");
        return madLibRepo.findById(id);
    }

    public Boolean deleteMadLib(Long id) {
        log.info("delete called from service");
        madLibRepo.deleteById(id);
        return true;
    }

    public List<MadLib> getAllMadLib() {
        log.info("Get all called from Service");
        return madLibRepo.findAll();
    }
}
