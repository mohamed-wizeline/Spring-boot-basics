package com.example.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc               //Don't forget this annotation, or mockMvc wont work.
public class WeatherControllerTest {


    //You need to autowire a mockMvc object to be able to use it in any of your tests.
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetWeatherFunction() throws Exception {
        this.mockMvc.perform(get("/"))      //Mocks a GET call to the endpoint "/"
                .andDo(print())         //Prints the response body in the console so you could see it.
                .andExpect(content().contentType("application/json;charset=UTF-8"))     //Tests that the response type is JSON.
                .andExpect(status().isOk())         //Tests that the response status isOk(you have other response statuses).
                .andExpect(jsonPath("$", hasSize(2)))       //Tests the response array length.
                .andExpect(jsonPath("$[0].*", hasSize(4)))      //Tests that element number 0 in response array has 4 attributes.
                .andExpect(jsonPath("$[0].temp").value("74.2"))     //Tests that element 0 in the response array has a field called temp, and it has value 74.2.
                .andExpect(jsonPath("$[0].relativeHumid").value("74.2"))
                .andExpect(jsonPath("$[0].windSpd").value("2"))
                .andExpect(jsonPath("$[0].windDir").value("215"));
    }
}
