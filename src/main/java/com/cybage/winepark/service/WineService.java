package com.cybage.winepark.service;

import com.cybage.winepark.domain.Wine;


import java.util.List;
public interface WineService {
    public List<Wine> getAllWines();

    public Wine getWineById(Integer wineId);

    public void addWine(Wine wine);

    public void updateWine(Wine wine);

    public void deleteWine(Integer wineId);
}
