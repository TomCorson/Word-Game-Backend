package com.example.wordgamebackend.Controllers;

import com.example.wordgamebackend.Entities.MadLib;
import com.example.wordgamebackend.Repos.MadLibRepo;
import com.example.wordgamebackend.Services.MadLibService;
import com.example.wordgamebackend.WordGameBackendApplication;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

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
    public static final List<String> MADLIB_1_PARTSOFSPEECH = Arrays.asList("word","word","word");
    public static final List<String> MADLIB_2_PARTSOFSPEECH = Arrays.asList("word","word","word");
    public static final List<String> MADLIB_3_PARTSOFSPEECH = Arrays.asList("word","word","word");


    private MockMvc mockMvc;
    private HttpMessageConverter mappingJackson2HttpMessageConverter;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private MadLibRepo madLibRepo;
    @Autowired
    private MadLibService madLibService;
    @Autowired
    public void setConverters(HttpMessageConverter<?>[] converters){
        mappingJackson2HttpMessageConverter = Arrays.asList(converters)
                                                    .stream()
                                                    .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                                                    .findAny()
                                                    .orElse(null);
        Assert.assertNotNull("the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter);
    }

    @org.junit.Before
    public void setUp() throws Exception {
        MadLib madLib1 = new MadLib(MADLIB_1_ID, MADLIB_1_NAME, MADLIB_1_STORY, MADLIB_1_PARTSOFSPEECH);
        MadLib madLib2 = new MadLib(MADLIB_2_ID, MADLIB_2_NAME, MADLIB_2_STORY, MADLIB_2_PARTSOFSPEECH);
        MadLib madLib3 = new MadLib(MADLIB_3_ID, MADLIB_3_NAME, MADLIB_3_STORY, MADLIB_3_PARTSOFSPEECH);
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