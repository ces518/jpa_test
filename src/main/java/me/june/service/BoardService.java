package me.june.service;

import me.june.dto.BoardDTO;
import me.june.entity.Board;
import me.june.repository.BoardRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public Page<Board> findAll(BoardDTO boardDTO, PageRequest pageRequest){
        if(!StringUtils.isBlank(boardDTO.getTitle())){
            return boardRepository.findBoardsByTitle(boardDTO.getTitle(),pageRequest);
        }
        return boardRepository.findAll(pageRequest);
    }
//
//    public List<Board> findBoardsByTitle(BoardDTO boardDTO,PageRequest pageRequest){
//        return boardRepository.findBoardsByTitle(boardDTO.getTitle(),pageRequest);
//    }

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
