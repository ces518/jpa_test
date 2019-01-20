package me.june.service;

import me.june.dto.BoardDTO;
import me.june.entity.Board;
import me.june.jpapagingtest.JpaPagingTestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {JpaPagingTestApplication.class})
public class BoardServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BoardService boardService;

    @Test
    public void list(){
        List<Board> list = boardService.findAll(new BoardDTO());
        logger.info("list size = {}",list.size());
    }

    @Test
    public void save(){
        BoardDTO boardDTO = BoardDTO.builder().content("내용").title("제목")
                        .build();
        Board saveBoard = boardService.createBoard(boardDTO);
        List<Board> list = boardService.findAll(boardDTO);
        logger.info("list size = {}",list.size());
        assertThat(list.size(),is(1));
    }

    @Test
    public void findBoardsByTitle(){
        BoardDTO boardDTO = BoardDTO.builder().title("제목").build();

        List<Board> list = boardService.findBoardsByTitle(boardDTO);
        logger.info("list size = {}",list.size());
        assertThat(list.size(),is(1));
    }

    @Test
    public void updateBoard(){
        BoardDTO boardDTO = BoardDTO.builder().id(1L).title("제목수정").build();
        Board board = boardService.updateBoard(boardDTO);
        logger.info("update title = {}",board.getTitle());
        assertThat(board.getTitle(),is("제목수정"));

        Board updatedBoard = boardService.findOne(boardDTO);
        logger.info("updated title = {}",updatedBoard.getTitle());
        assertThat(updatedBoard.getTitle(),is("제목수정"));
    }
}