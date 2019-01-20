package me.june.repository;

import me.june.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {

    public List<Board> findBoardsByTitle(String title);
}
