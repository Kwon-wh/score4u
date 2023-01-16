package com.futsal.score4u.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    @Min(value = 1)
    @Positive
    private int page = 1;

    @Builder.Default
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size = 10;
    private String link;


    public int getSkip() {
        return (page - 1 ) * 10;
    }

    // 검색
    private String[] types;
    private String keyword;
    private boolean finished;
    private LocalDate from;
    private LocalDateTime time;

    public String getLink() {
        StringBuilder builder = new StringBuilder();
        builder.append("page=" + this.page);
        builder.append("&size=" + this.size);

        if(types != null && types.length > 0) {
            for (int i =0; i < types.length; i++) {
                builder.append("&types=" + types[i]);
            }
        }

        if(keyword != null) {
            try {
                builder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8"));

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        if(from != null) {
            builder.append("&from" + from.toString());
        }

        return builder.toString();
    }

    public boolean checkType(String type) {
        if(types == null || types.length == 0) {
            return false;
        }

        return Arrays.stream(types).anyMatch(type::equals);
    }


}
