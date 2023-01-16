package com.futsal.score4u.service;

import com.futsal.score4u.domain.TeamVO;
import com.futsal.score4u.domain.UserVO;
import com.futsal.score4u.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void TestInsert() {
        UserDTO userDTO = UserDTO.builder()
                .id("user03")
                .pw("user03")
                .name("권우희")
                .phone("01089858953")
                .build();

        userService.joinUser(userDTO);

    }
}
