package com.futsal.score4u.service;

import com.futsal.score4u.dto.TeamDTO;

public interface TeamService {
    TeamDTO getTeam(Long mSeqNo);

    void insertTeam(TeamDTO teamDTO);
}
