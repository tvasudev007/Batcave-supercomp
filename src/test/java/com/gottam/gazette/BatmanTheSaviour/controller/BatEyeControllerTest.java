package com.gottam.gazette.BatmanTheSaviour.controller;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gottam.gazette.BatmanTheSaviour.dto.ErrorResponseDTO;
import com.gottam.gazette.BatmanTheSaviour.dto.LocationResponseDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
@WebAppConfiguration
public class BatEyeControllerTest
{

    private MockMvc mvc;

    /**
     * @throws Exception
     *             -
     */
    @Before
    public void setUp()
            throws Exception
    {
        this.mvc = MockMvcBuilders.standaloneSetup(new BatEyeController()).build();
    }

    /**
     * @throws Exception
     *             -
     */
    @SuppressWarnings("nls")
    @Test
    public void getWelcomeMessage()
            throws Exception
    {
    	this.mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().string(startsWith("Welcome to BatEyeController")));
    }
    
    @SuppressWarnings("nls")
    @Test
    public void testProbabilityByCoord()
            throws Exception
    {
    	ResultActions result=this.mvc.perform(MockMvcRequestBuilders.get("/coordinate?q=40.748288,-73.985645").accept(MediaType.APPLICATION_JSON));
        result.andExpect(MockMvcResultMatchers.status().isOk());
              
        String json=result.andReturn().getResponse().getContentAsString();
        ObjectMapper mapper=new ObjectMapper();
        LocationResponseDTO response=mapper.readValue(json, LocationResponseDTO.class);
        Assert.assertTrue(response.getTargets().size()==2);
    }
    
    @SuppressWarnings("nls")
    @Test
    public void testProbabilityByCoordOutSideBoundary()
            throws Exception
    {
    	ResultActions result=this.mvc.perform(MockMvcRequestBuilders.get("/coordinate?q=44.748288,-73.985645").accept(MediaType.APPLICATION_JSON));
        result.andExpect(MockMvcResultMatchers.status().isOk());
              
        String json=result.andReturn().getResponse().getContentAsString();
        ObjectMapper mapper=new ObjectMapper();
        ErrorResponseDTO response=mapper.readValue(json, ErrorResponseDTO.class);
        Assert.assertTrue(response.getErrorMessage().equals("Desole, Bat Eye Tracker unable to given location !!"));
    }
    
    @SuppressWarnings("nls")
    @Test
    public void testProbabilityByAddressOutsideBoundary()
            throws Exception
    {
    	ResultActions result=this.mvc.perform(MockMvcRequestBuilders.get("/address?q=paris").accept(MediaType.APPLICATION_JSON));
        result.andExpect(MockMvcResultMatchers.status().isOk());
              
        String json=result.andReturn().getResponse().getContentAsString();
        ObjectMapper mapper=new ObjectMapper();
        ErrorResponseDTO response=mapper.readValue(json, ErrorResponseDTO.class);
        Assert.assertTrue(response.getErrorMessage().equals("Desole, Bat Eye Tracker unable to given location !!"));
    }
    
    @SuppressWarnings("nls")
    @Test
    public void testProbabilityByAddress()
            throws Exception
    {
    	ResultActions result=this.mvc.perform(MockMvcRequestBuilders.get("/address?q=Empire State Building, 350 5th Ave, New York, NY 10118, USA").accept(MediaType.APPLICATION_JSON));
        result.andExpect(MockMvcResultMatchers.status().isOk());
              
        String json=result.andReturn().getResponse().getContentAsString();
        ObjectMapper mapper=new ObjectMapper();
        LocationResponseDTO response=mapper.readValue(json, LocationResponseDTO.class);
        Assert.assertTrue(response.getTargets().size()==2);
    }
}
