package com.cybage.winepark.repository;

import com.cybage.winepark.domain.Wine;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class WineRepositoryTest {
    private TestEntityManager entityManager;
    WineRepository repository;



//    @Test
//    void checkFindByWineId() {
//        //given
//        Integer wineId=1;
//        Wine wine = repository.save(new Wine(wineId, 2, "red", "sula", 200.00));
//        //when
//        Wine expected=repository.findByWineId(wine.getWineId());
//        //then
//        assertThat(expected).isEqualTo(wine);
//    }
}