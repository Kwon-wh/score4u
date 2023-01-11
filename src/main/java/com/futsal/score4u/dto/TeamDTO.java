package com.futsal.score4u.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {
    private Long seqNo;
    @NotEmpty
    private String teamName;
    @NotEmpty
    private String city;
    @NotEmpty
    private String streetAddr;
    @NotNull
    private Long mSeqNo;
    private Long matchingNum;

}
