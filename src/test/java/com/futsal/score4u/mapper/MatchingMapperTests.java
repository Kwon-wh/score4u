package com.futsal.score4u.mapper;

import com.futsal.score4u.domain.MatchingVO;
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
        List<MatchingVO> voList = matchingMapper.selectAll();

        voList.forEach(vo -> System.out.println(voList));
    }


}
