package com.futsal.score4u.mapper;

import com.futsal.score4u.domain.TeamVO;

import java.util.List;

public interface TeamMapper {
    TeamVO select(Long seqNo);

    void insert(TeamVO teamVO);
}
