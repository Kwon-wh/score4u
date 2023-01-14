package com.futsal.score4u.mapper;

import com.futsal.score4u.domain.MatchingVO;
import com.futsal.score4u.dto.PageRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class MatchingMapperTests {

    @Autowired(required = false)
    private MatchingMapper matchingMapper;

    @Test
    public void testSelectAll() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        List<MatchingVO> voList = matchingMapper.selectAll(pageRequestDTO);

        voList.forEach(vo -> System.out.println(voList));
    }


}
