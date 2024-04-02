package com.cybage.winepark.controller;

import com.cybage.winepark.controller.WineController;
import com.cybage.winepark.domain.Wine;
import com.cybage.winepark.dto.WineDto;
import com.cybage.winepark.service.WineService;
import com.cybage.winepark.service.WineServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class WineControllerTest {

    @InjectMocks
    private WineController wineController;

    @Mock
    private WineService wineService;

    @Mock
    private WineServiceImpl wineServiceImpl;


    @Test
    void addWine() {
        // Mock data
        WineDto wineDto = new WineDto();
        Wine wine = new Wine();

        // Mocking the service methods
        when(wineServiceImpl.wineDtoToWine(any())).thenReturn(wine);
        Mockito.doNothing().when(wineService).addWine(any());

        // Calling the controller method
        ResponseEntity<String> response = wineController.addWine(wineDto);

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("wine added successfully...", response.getBody());
    }
    // @Test
    // void getAllWines() {
    //     // Mock data
    //     List<Wine> wines = Arrays.asList(new Wine(1, 2, "red", "sula", 200.00), new Wine(2, 2, "red", "sula", 200.00));

    //     // Mocking the service method
    //     when(wineService.getAllWines()).thenReturn(wines);

    //     // Calling the controller method
    //     ResponseEntity<List<Wine>> response = wineController.getAllWines();

    //     // Assertions
    //     assertEquals(HttpStatus.OK, response.getStatusCode());
    //     assertEquals(wines, response.getBody());
    // }



    // @Test
    // void getWineById() {
    //     // Mock data
    //     Wine wine = new Wine();
    //     int wineId = 1;

    //     // Mocking the service method
    //     when(wineService.getWineById(wineId)).thenReturn(wine);

    //     // Calling the controller method
    //     ResponseEntity<Wine> response = wineController.getWineById(wineId);

    //     // Assertions
    //     assertEquals(HttpStatus.OK, response.getStatusCode());
    //     assertEquals(wine, response.getBody());
    // }



    @Test
    void updateWine() {
        // Mock data
        WineDto wineDto = new WineDto();
        int wineId = 2;
        Wine wine = new Wine();  // Assuming Wine class has a setter for wineId

        // Mocking the service methods
        when(wineServiceImpl.wineDtoToWine(any())).thenReturn(wine);
        Mockito.doNothing().when(wineService).updateWine(any());

        // Calling the controller method
        ResponseEntity<String> response = wineController.updateWine(wineId, wineDto);

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("wine updated successfully...", response.getBody());

        // Additional assertion to check if wineId is set correctly
        assertEquals(wineId, wine.getWineId());
    }

    @Test
    void deleteWine() {
        // Mock data
        int wineId = 1;

        // Mocking the service method
        Mockito.lenient().doNothing().when(wineService).deleteWine(eq(wineId));

        // Calling the controller method
        ResponseEntity<String> response = wineController.deleteWine(wineId);

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("wine deleted successfully...", response.getBody());
    }
}
