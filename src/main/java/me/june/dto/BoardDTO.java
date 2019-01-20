package me.june.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {

    private Long id = 0L;

    private String title = "";

    private String content = "";
}
