package com.test.spotify;

import com.test.spotify.dto.WeatherResponse;
import com.test.spotify.resource.WeatherResource;
import com.test.spotify.service.WeatherService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(WeatherResponse.class)
@AutoConfigureMockMvc
public class WeatherResourceTest {
    
    @MockBean
    private WeatherService weatherService;

    @MockBean
    private WeatherResource weatherResource;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getWeather() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/weather/curitiba")).andExpect(MockMvcResultMatchers.status().isOk());
    }
    
}
