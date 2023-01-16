package com.futsal.score4u.service;

import com.futsal.score4u.domain.UserVO;
import com.futsal.score4u.dto.UserDTO;
import com.futsal.score4u.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final ModelMapper modelMapper;

    @Override
    public void joinUser(UserDTO userDTO) {
        UserVO userVO = modelMapper.map(userDTO, UserVO.class);

        log.info(userVO);
        userMapper.insert(userVO);
    }
}
