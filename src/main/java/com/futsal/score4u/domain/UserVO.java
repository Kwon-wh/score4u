package com.futsal.score4u.domain;

import lombok.*;

import javax.validation.constraints.NotNull;


@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

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
