package com.futsal.score4u.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TeamVO {
    private Long seqNo;
    private String teamName;
    private String city;
    private String streetAddr;
    private Long mSeqNo;
    private Long matchingNum;

}
