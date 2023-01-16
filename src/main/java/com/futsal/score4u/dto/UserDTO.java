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
public class UserDTO {

    Long seqNo;
    @NotNull
    String id;
    @NotNull
    String pw;
    @NotNull
    String name;
    @NotNull
    String phone;
    Long teamSeq;

}
