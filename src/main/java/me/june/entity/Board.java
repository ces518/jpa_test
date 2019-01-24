package me.june.entity;

import lombok.*;
import me.june.dto.BoardDTO;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "board")
@Getter
@Setter
@NoArgsConstructor
// JPA 캐시전략
//@org.hibernate.annotations.Cache(region = "board")
// 등록일 수정일 자동등록
@EntityListeners(AuditingEntityListener.class)
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

    //생성일
    @CreatedDate
    private LocalDate createdAt;

    //수정일
    @LastModifiedDate
    private LocalDate updatedAt;

    @Builder
    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
