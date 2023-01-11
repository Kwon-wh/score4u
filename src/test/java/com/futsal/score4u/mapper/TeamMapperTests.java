package com.futsal.score4u.mapper;

import com.futsal.score4u.domain.MatchingVO;
import com.futsal.score4u.domain.TeamVO;
import com.futsal.score4u.service.TeamService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TeamMapperTests {

    @Autowired(required = false)
    private TeamMapper teamMapper;

    @Test
    public void testInsert() {

        TeamVO teamVO = TeamVO.builder()
                .teamName("팀이름")
                .city("서울특별시")
                .streetAddr("용산구 이태원동")
                .mSeqNo(1L)
                .build();

        teamMapper.insert(teamVO);
    }


}
