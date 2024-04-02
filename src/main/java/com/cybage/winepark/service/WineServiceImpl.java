package com.cybage.winepark.service;

import com.cybage.winepark.dto.WineDto;
import com.cybage.winepark.repository.WineRepository;
import com.cybage.winepark.domain.Wine;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@Service
@AllArgsConstructor
public class WineServiceImpl implements WineService {
    private WineRepository wineRepository;

    @Override
    public List<Wine> getAllWines() {
        return wineRepository.findAll();
    }

    @Override
    public Wine getWineById(Integer wineId) {
        return wineRepository.findByWineId(wineId);
    }

    @Override
    public void addWine(Wine wine) {
        wineRepository.save(wine);
    }

    @Override
    public void updateWine(Wine wine) {
        wineRepository.save(wine);
    }

    @Override
    public void deleteWine(Integer wineId) {
        wineRepository.deleteById(wineId);
    }

    public Wine wineDtoToWine(WineDto wineDto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(wineDto, Wine.class);
    }
    public WineDto wineToWineDto(Wine wine){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(wine, WineDto.class);
    }
}
