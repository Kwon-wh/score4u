package com.futsal.score4u.service;

import com.futsal.score4u.controller.TeamController;
import com.futsal.score4u.domain.TeamVO;
import com.futsal.score4u.dto.MatchingDTO;
import com.futsal.score4u.dto.TeamDTO;
import com.futsal.score4u.mapper.TeamMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService{

    private final TeamMapper teamMapper;
    private final ModelMapper modelMapper;


    @Override
    public TeamDTO getTeam(Long mSeqNo) {
        TeamVO teamVO = teamMapper.select(mSeqNo);

        return modelMapper.map(teamVO, TeamDTO.class);
    }

    @Override
    public void insertTeam(TeamDTO teamDTO) {
        TeamVO teamVO = modelMapper.map(teamDTO, TeamVO.class);
        log.info(teamVO);
        teamMapper.insert(teamVO);
    }
}
