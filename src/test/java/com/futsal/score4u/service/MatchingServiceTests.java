package com.futsal.score4u.service;

import com.futsal.score4u.domain.MatchingVO;
import com.futsal.score4u.dto.MatchingDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class MatchingServiceTests {

    @Autowired
    private MatchingService matchingService;

    @Test
    public void getAllTest() {
        List<MatchingDTO> matchingDTO = matchingService.getAll();

        matchingDTO.forEach(vo -> System.out.println(matchingDTO));
    }

    @Test
    public void getOneTest() {
        MatchingDTO matchingVO = matchingService.getOne(2L);

        System.out.println(matchingVO);
    }

    @Test
    public void insertTest() {
        MatchingDTO matchingDTO = MatchingDTO.builder()
                .team("team5")
                .city("서울")
                .streetAddr("용산구")
                .matchLocation("서울시")
                .matchDate(LocalDate.now())
                .build();
        matchingService.insert(matchingDTO);
    }

    @Test
    public void updateFinishedTest() {
        MatchingDTO matchingDTO = MatchingDTO.builder()
                .finished(true)
                .seqNo(3L)
                .build();

        matchingService.updateFinished(matchingDTO);
    }
}
