package com.futsal.score4u.mapper;

import com.futsal.score4u.domain.MatchingVO;

import java.util.List;

public interface MatchingMapper {
    List<MatchingVO> selectAll();

    MatchingVO selectOne(Long seq);

    void insert(MatchingVO matchingVO);

    void updateFinished(MatchingVO matchingVO);

}
