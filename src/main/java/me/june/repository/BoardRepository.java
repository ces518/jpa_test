package me.june.repository;

import me.june.dto.BoardDTO;
import me.june.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {

    public Page<Board> findBoardsByTitle(String title,Pageable pageable);

    public Page<Board> findAll(Pageable pageable);
}
