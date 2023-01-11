package com.futsal.score4u.service;

import com.futsal.score4u.domain.TeamVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TeamServiceTests {

    @Autowired
    private TeamService teamService;

    @Test
    public void TestInsert() {
        TeamVO teamVO = TeamVO.builder()
                .teamName("팀이름2")
                .city("서울특별시")
                .streetAddr("마포구 여의도동")
                .mSeqNo(3L)
                .build();
    }
}
