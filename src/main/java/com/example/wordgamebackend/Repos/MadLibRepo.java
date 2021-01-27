package com.example.wordgamebackend.Repos;

import com.example.wordgamebackend.Entities.MadLib;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MadLibRepo extends JpaRepository<MadLib,Long> {
}
