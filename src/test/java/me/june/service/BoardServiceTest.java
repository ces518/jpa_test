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
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {JpaPagingTestApplication.class},webEnvironment = RANDOM_PORT)
public class BoardServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private BoardService boardService;

    //web 통합테스트
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void test1(){
        System.out.println(testRestTemplate.getForObject("/board",String.class));
    }


    @Test
    public void list(){
        /*List<Board> list = boardService.findAll(new BoardDTO());
        logger.info("list size = {}",list.size());
        */
    }

    @Test
    public void save(){
        BoardDTO boardDTO = BoardDTO.builder().content("내용").title("제목").build();
        Board saveBoard = boardService.createBoard(boardDTO);

        PageRequest pageRequest = new PageRequest(0,10,Sort.Direction.DESC,"seq");

        Page<Board> list = boardService.findAll(boardDTO,pageRequest);
        logger.info("list size = {}",list.getTotalElements());

        logger.info("createdAt = {} , updatedAt = {}",saveBoard.getCreatedAt(),saveBoard.getUpdatedAt());
    }

//    @Test
//    public void findBoardsByTitle(){
//        BoardDTO boardDTO = BoardDTO.builder().title("제목").build();
//        PageRequest pageRequest = new PageRequest(0,10, Sort.Direction.DESC,"seq");
//            Page<Board> list = boardService.findBoardsByTitle(boardDTO,pageRequest);
//        logger.info("list size = {}",list.getContent().size());
//        assertThat(list.getContent().size(),is(1));
//    }

    @Test
    public void updateBoard(){
        BoardDTO boardDTO = BoardDTO.builder().id(8L).title("제목수정").build();
        Board board = boardService.updateBoard(boardDTO);
        logger.info("update title = {}",board.getTitle());
        assertThat(board.getTitle(),is("제목수정"));

        Board updatedBoard = boardService.findOne(boardDTO);
        logger.info("updated title = {}",updatedBoard.getTitle());
        assertThat(updatedBoard.getTitle(),is("제목수정"));

        logger.info("updatedAt = {}",updatedBoard.getUpdatedAt());
    }
}