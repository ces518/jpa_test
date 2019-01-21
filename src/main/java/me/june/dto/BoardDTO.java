package me.june.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {

    private int page = 0;

    private Long id = 0L;

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;
}
