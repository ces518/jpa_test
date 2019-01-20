package me.june.service;

import me.june.dto.BoardDTO;
import me.june.entity.Board;
import me.june.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public List<Board> findAll(BoardDTO boardDTO){
        return boardRepository.findAll();
    }

    public List<Board> findBoardsByTitle(BoardDTO boardDTO){
        return boardRepository.findBoardsByTitle(boardDTO.getTitle());
    }

    public Board findOne(BoardDTO boardDTO){
        return boardRepository.getOne(boardDTO.getId());
    }

    public Board createBoard(BoardDTO boardDTO){
        Board newBoard = new Board(boardDTO);
        Board savedBoard =  boardRepository.save(newBoard);
        return savedBoard;
    }

    /**
     * 변경감지로 인해 자동적으로 수정이됨.
     * @param boardDTO
     * @return
     */
    public Board updateBoard(BoardDTO boardDTO){
        Board savedBoard = boardRepository.getOne(boardDTO.getId());
        savedBoard.setTitle(boardDTO.getTitle());
        savedBoard.setContent(boardDTO.getContent());
        return savedBoard;
    }
}
