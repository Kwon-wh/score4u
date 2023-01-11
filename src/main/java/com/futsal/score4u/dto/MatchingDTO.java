package com.futsal.score4u.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatchingDTO {

    private Long seqNo;
    @NotEmpty
    private String team;
    @NotEmpty
    private String city;
    @NotEmpty
    private String streetAddr;
    private String matchLocation;
    @Future
    private LocalDate matchDate;
    private boolean finished;

}
