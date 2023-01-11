package com.futsal.score4u.domain;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MatchingVO {
    private Long seqNo;
    private String team;
    private String city;
    private String streetAddr;
    private String matchLocation;
    private LocalDate matchDate;
    private boolean finished;
}
