package me.june.entity;

import lombok.*;
import me.june.dto.BoardDTO;

import javax.persistence.*;

@Entity
@Table(name = "board")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
// JPA 캐시전략
//@org.hibernate.annotations.Cache(region = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seq = 0L;

    @Column(name = "title",length = 1000)
    private String title;

    @Column(name= "content", length = 4000)
    private String content;

    public Board(BoardDTO boardDTO){
        this.title = boardDTO.getTitle();
        this.content = boardDTO.getContent();
    }
}
