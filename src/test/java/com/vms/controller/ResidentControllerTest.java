package com.vms.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vms.model.Resident;
import com.vms.service.ResidentService;


@WebMvcTest(ResidentController.class)
public class ResidentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ResidentService residentService;

    @Autowired
    private ObjectMapper objectMapper;

    private Resident testResident;
    private List<Resident> residentList;
    private Map<String, List<Resident>> roleMap;

    @BeforeEach
    void setUp() {
        testResident = new Resident();
        testResident.setId(1L);
        testResident.setRole("TENANT");

        residentList = Arrays.asList(testResident);
        
        roleMap = new HashMap<>();
        roleMap.put("TENANT", residentList);
    }

    @Test
    void getAllResidents_ShouldReturnList() throws Exception {
        when(residentService.getAll()).thenReturn(residentList);

        mockMvc.perform(get("/vms/api/v1/resident"))
               .andExpect(status().isOk())
               .andExpect(content().json(objectMapper.writeValueAsString(residentList)));

        verify(residentService).getAll();
    }

    @Test
    void getResidentById_ShouldReturnResident() throws Exception {
        when(residentService.getById(1L)).thenReturn(testResident);

        mockMvc.perform(get("/vms/api/v1/resident/1"))
               .andExpect(status().isOk())
               .andExpect(content().json(objectMapper.writeValueAsString(testResident)));

        verify(residentService).getById(1L);
    }

    @Test
    void getByRole_NoParam_ShouldReturnMap() throws Exception {
        when(residentService.getByRole()).thenReturn(roleMap);

        mockMvc.perform(get("/vms/api/v1/resident/role"))
               .andExpect(status().isOk())
               .andExpect(content().json(objectMapper.writeValueAsString(roleMap)));

        verify(residentService).getByRole();
    }

    @Test
    void getByRole_WithParam_ShouldReturnFilteredMap() throws Exception {
        when(residentService.getByRole("TENANT")).thenReturn(roleMap);

        mockMvc.perform(get("/vms/api/v1/resident/role/TENANT"))
               .andExpect(status().isOk())
               .andExpect(content().json(objectMapper.writeValueAsString(roleMap)));

        verify(residentService).getByRole("TENANT");
    }

    @Test
    void createResident_ShouldReturnCreatedResident() throws Exception {
        when(residentService.create(any(Resident.class))).thenReturn(testResident);

        mockMvc.perform(post("/vms/api/v1/resident")
               .contentType(MediaType.APPLICATION_JSON)
               .content(objectMapper.writeValueAsString(testResident)))
               .andExpect(status().isOk())
               .andExpect(content().json(objectMapper.writeValueAsString(testResident)));

        verify(residentService).create(any(Resident.class));
    }

    @Test
    void updateResident_ShouldReturnUpdatedResident() throws Exception {
        when(residentService.update(eq(1L), any(Resident.class))).thenReturn(testResident);

        mockMvc.perform(put("/vms/api/v1/resident/1")
               .contentType(MediaType.APPLICATION_JSON)
               .content(objectMapper.writeValueAsString(testResident)))
               .andExpect(status().isOk())
               .andExpect(content().json(objectMapper.writeValueAsString(testResident)));

        verify(residentService).update(eq(1L), any(Resident.class));
    }

    @Test
    void deleteResident_ShouldDeleteSuccessfully() throws Exception {
        doNothing().when(residentService).delete(1L);

        mockMvc.perform(delete("/vms/api/v1/resident/1"))
               .andExpect(status().isOk());

        verify(residentService).delete(1L);
    }
}