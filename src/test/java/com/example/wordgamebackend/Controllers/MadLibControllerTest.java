package com.example.wordgamebackend.Controllers;

import com.example.wordgamebackend.Entities.MadLib;
import com.example.wordgamebackend.Repos.MadLibRepo;
import com.example.wordgamebackend.Services.MadLibService;
import com.example.wordgamebackend.WordGameBackendApplication;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.NestedServletException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.util.Arrays;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = WordGameBackendApplication.class)
@WebAppConfiguration
@AutoConfigureMockMvc
public class MadLibControllerTest {

    public static final long MADLIB_1_ID = 1L;
    public static final long MADLIB_2_ID = 2L;
    public static final long MADLIB_3_ID = 3L;
    public static final String MADLIB_1_NAME = "One Name";
    public static final String MADLIB_2_NAME = "Two Name";
    public static final String MADLIB_3_NAME = "Three Name";
    public static final String MADLIB_1_STORY = "One Story";
    public static final String MADLIB_2_STORY = "Two Story";
    public static final String MADLIB_3_STORY = "Three Story";
    public static final List<String> MADLIB_1_PARTSOFSPEECH = Arrays.asList("word","word","word");
    public static final List<String> MADLIB_2_PARTSOFSPEECH = Arrays.asList("word","word","word");
    public static final List<String> MADLIB_3_PARTSOFSPEECH = Arrays.asList("word","word","word");
    private static MediaType CONTENT_TYPE = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype());


    private MockMvc mockMvc;
    private HttpMessageConverter mappingJackson2HttpMessageConverter;
    @Autowired
    private MadLibController madLibController;
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

//    @org.junit.Before
//    public void setUp() throws Exception {
//        mockMvc = webAppContextSetup(webApplicationContext).build();
//        madLibRepo.deleteAll();
//        MadLib madLib1 = new MadLib(MADLIB_1_ID, MADLIB_1_NAME, MADLIB_1_STORY, MADLIB_1_PARTSOFSPEECH);
//        MadLib madLib2 = new MadLib(MADLIB_2_ID, MADLIB_2_NAME, MADLIB_2_STORY, MADLIB_2_PARTSOFSPEECH);
//        MadLib madLib3 = new MadLib(MADLIB_3_ID, MADLIB_3_NAME, MADLIB_3_STORY, MADLIB_3_PARTSOFSPEECH);
//        System.out.printf("ABOUT TO SAVE THE MADLIBS: %S AND %S AND %S", madLib1.toString(),madLib2.toString(),madLib3
//        .toString());
//        madLibRepo.save(madLib1);
//        madLibRepo.save(madLib2);
//        madLibRepo.save(madLib3);
//        System.out.println("DONE WITH THE SET UP and saved!!!!!!");
//
//    }
//
//    @org.junit.After
//    public void tearDown() throws Exception {
//        madLibRepo.deleteById(1L);
//        madLibRepo.deleteById(2L);
//        madLibRepo.deleteById(3L);
//    }
    @org.junit.Test(expected = NestedServletException.class)
    public void getNonExistentMadLib() throws Exception {
        this.mockMvc.perform(get("/222"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(CONTENT_TYPE));
    }

    @org.junit.Test
    public void getMadLib() throws Exception {
        this.mockMvc.perform(get("/70"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.name", Matchers.is(MADLIB_1_NAME)))
                .andExpect(jsonPath("$.story", Matchers.is(MADLIB_1_STORY)))
                .andExpect(jsonPath("$.partsOfSpeech", Matchers.is(MADLIB_1_PARTSOFSPEECH)));
    }

    @org.junit.Test
    public void addMadLib() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        MadLib madLib1 = new MadLib(MADLIB_1_ID, MADLIB_1_NAME, MADLIB_1_STORY, MADLIB_1_PARTSOFSPEECH);
        when(madLibRepo.save(any(MadLib.class))).thenReturn(madLib1);
        ResponseEntity<?> responseEntity = madLibController.createMadLib(madLib1);
        System.out.println("Did we get here");
        assertThat(responseEntity.getStatusCode().is2xxSuccessful());

    }

    @org.junit.Test
    public void createMadLib() {
    }

    @org.junit.Test
    public void deleteMadLib() {
    }
}