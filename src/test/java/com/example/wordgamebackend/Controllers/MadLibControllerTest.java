package com.example.wordgamebackend.Controllers;

import com.example.wordgamebackend.WordGameBackendApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WordGameBackendApplication.class)
@WebAppConfiguration
public class MadLibControllerTest {

    public static final long MADLIB_1_ID = 1l;
    public static final long MADLIB_2_ID = 2l;
    public static final long MADLIB_3_ID = 3l;
    public static final String MADLIB_1_NAME = "One Name";
    public static final String MADLIB_2_NAME = "Two Name";
    public static final String MADLIB_3_NAME = "Three Name";
    public static final String MADLIB_1_STORY = "One Story";
    public static final String MADLIB_2_STORY = "Two Story";
    public static final String MADLIB_3_STORY = "Three Story";

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void getMadLib() {
    }

    @org.junit.Test
    public void getAllMadLib() {
    }

    @org.junit.Test
    public void createMadLib() {
    }

    @org.junit.Test
    public void deleteMadLib() {
    }
}