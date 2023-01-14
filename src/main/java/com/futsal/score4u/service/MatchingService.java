package com.futsal.score4u.service;

import com.futsal.score4u.domain.MatchingVO;
import com.futsal.score4u.dto.MatchingDTO;
import com.futsal.score4u.dto.PageRequestDTO;
import com.futsal.score4u.dto.PageResponseDTO;

import java.util.List;

public interface MatchingService {
//    List<MatchingDTO> getAll();
    PageResponseDTO<MatchingDTO> getList(PageRequestDTO pageRequestDTO);

    MatchingDTO getOne(Long seqNo);

    void insert(MatchingDTO matchingDTO);

    void updateFinished(MatchingDTO matchingDTO);
}
