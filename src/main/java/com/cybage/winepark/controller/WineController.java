package com.cybage.winepark.controller;

import com.cybage.winepark.service.WineService;
import com.cybage.winepark.domain.Wine;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cybage.winepark.service.WineServiceImpl;
import com.cybage.winepark.dto.WineDto;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
@RequestMapping("wine")
@Slf4j
@AllArgsConstructor
public class WineController {
    WineService wineService;
    WineServiceImpl wineServiceImpl;
    static final String HEADERS = "Host Info";

    @GetMapping("getAllWines")
    public ResponseEntity<List<Wine>> getAllWines() {
        log.info("CONTROLLER: getAllWines");
        List<Wine> wines = wineService.getAllWines();
        return new ResponseEntity<>(wines, HttpStatus.OK);
    }

    @GetMapping("getWineById/{id}")
    public  ResponseEntity<Wine> getWineById(@PathVariable("id") Integer id) {
        log.info("CONTROLLER: getWineById");
        Wine wine = wineService.getWineById(id);
        return new ResponseEntity<>(wine,HttpStatus.OK);
    }

    @PostMapping("add")
    public  ResponseEntity<String> addWine(@RequestBody WineDto wineDto) {
        log.info("CONTROLLER: addWine");
        Wine wine=wineServiceImpl.wineDtoToWine(wineDto);
        wineService.addWine(wine);
        return new ResponseEntity<>("wine added successfully...", HttpStatus.OK);
    }

    @PutMapping("updateWine/{id}")
    public  ResponseEntity<String> updateWine(@PathVariable("id") Integer id,@RequestBody WineDto wineDto) {
        log.info("CONTROLLER: updateWine");
        Wine wine=wineServiceImpl.wineDtoToWine(wineDto);
        wine.setWineId(id);
        wineService.updateWine(wine);
        return new ResponseEntity<>("wine updated successfully...",HttpStatus.OK);
    }

    @DeleteMapping("deleteWine/{id}")
    public  ResponseEntity<String> deleteWine(@PathVariable("id") Integer id) {
        log.info("CONTROLLER: deleteWine");
        wineService.deleteWine(id);
        return new ResponseEntity<>("wine deleted successfully...",HttpStatus.OK);
    }


}






