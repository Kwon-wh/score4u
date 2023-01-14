package com.futsal.score4u.mapper;

import com.futsal.score4u.domain.MatchingVO;
import com.futsal.score4u.dto.PageRequestDTO;

import java.util.List;

public interface MatchingMapper {
    List<MatchingVO> selectAll(PageRequestDTO pageRequestDTO);

    MatchingVO selectOne(Long seq);

    void insert(MatchingVO matchingVO);

    void updateFinished(MatchingVO matchingVO);

    int getCount(PageRequestDTO pageRequestDTO);

}
