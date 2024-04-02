package com.cybage.winepark.service;

import com.cybage.winepark.domain.Wine;
import com.cybage.winepark.repository.WineRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WineServiceImplTest {
    @Mock
    private WineRepository wineRepository;
    private WineServiceImpl wineServiceImpl;
    Wine wine;

    @BeforeEach
    void setUp() {
        wineServiceImpl=new WineServiceImpl(wineRepository);
        wine = new Wine(1, 2, "red", "sula", 200.00);
    }


    @Test
    void testGetAllWines() {
        //when
        wineServiceImpl.getAllWines();
        //then
        verify(wineRepository).findAll();
    }

    @Test
    void testGetWineById() {
        Mockito.when(wineRepository.findByWineId(1)).thenReturn(wine);
        assertThat(wineServiceImpl.getWineById(1)).isEqualTo(wine);
    }

    @Test
    void testAddWine() {
        //given
//        Wine wine = new Wine(1, 2, "red", "sula", 200.00);
        //when
        wineServiceImpl.addWine(wine);
        //then
        ArgumentCaptor<Wine> wineArgumentCaptor= ArgumentCaptor.forClass(Wine.class);
        verify(wineRepository).save(wineArgumentCaptor.capture());
        Wine capturedWine= wineArgumentCaptor.getValue();
        assertThat(capturedWine).isEqualTo(wine);


    }

    @Test
    void testDeleteWine() {
        wineRepository.deleteById(1);
        assertThat(wineServiceImpl.getWineById(1)).isNull();
    }
}