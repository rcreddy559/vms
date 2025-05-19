package com.vms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(ResidentController.class)
public class ResidentControllerTest {

    @Autowired
    private MockMvc mockMvc;

}
