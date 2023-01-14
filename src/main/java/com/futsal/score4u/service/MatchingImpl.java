package com.futsal.score4u.service;

import com.futsal.score4u.domain.MatchingVO;
import com.futsal.score4u.dto.MatchingDTO;
import com.futsal.score4u.dto.PageRequestDTO;
import com.futsal.score4u.dto.PageResponseDTO;
import com.futsal.score4u.mapper.MatchingMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class MatchingImpl implements MatchingService{

    private final MatchingMapper matchingMapper;
    private final ModelMapper modelMapper;
//    @Override
//    public List<MatchingDTO> getAll() {
//        log.info("GetAll Service...............");
//
//        List<MatchingDTO> doList = matchingMapper.selectAll().stream()
//                .map(vo -> modelMapper.map(vo, MatchingDTO.class))
//                .collect(Collectors.toList());
//        return new ArrayList<>();
//    }

    @Override
    public PageResponseDTO<MatchingDTO> getList(PageRequestDTO pageRequestDTO) {
        List<MatchingVO> voList = matchingMapper.selectAll(pageRequestDTO);

        List<MatchingDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, MatchingDTO.class))
                .collect(Collectors.toList());
        int total = matchingMapper.getCount(pageRequestDTO);

        return PageResponseDTO.<MatchingDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();
    }

    @Override
    public MatchingDTO getOne(Long seq) {
        log.info("Get Read.................");
        MatchingVO matchingVO = matchingMapper.selectOne(seq);

        return modelMapper.map(matchingVO, MatchingDTO.class);
    }

    @Override
    public void insert(MatchingDTO matchingDTO) {
        log.info(modelMapper);

        MatchingVO matchingVO = modelMapper.map(matchingDTO, MatchingVO.class);

        log.info(matchingVO);
        matchingMapper.insert(matchingVO);
    }

    @Override
    public void updateFinished(MatchingDTO matchingDTO) {
        log.info(modelMapper);

        MatchingVO matchingVO = modelMapper.map(matchingDTO, MatchingVO.class);

        log.info(matchingVO);

        matchingMapper.updateFinished(matchingVO);
    }
}
