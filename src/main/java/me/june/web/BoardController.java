package me.june.web;


import me.june.dto.BoardDTO;
import me.june.entity.Board;
import me.june.service.BoardService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board")
    public String lst(
            BoardDTO boardDTO
            ,ModelMap model
    ){
        PageRequest pageRequest = new PageRequest(boardDTO.getPage(),5 ,Sort.Direction.DESC,"seq");
//        Page<Board> list = boardService.findAll(boardDTO,pageRequest);
//        System.out.println(list.getNumber());
//        model.addAttribute("total",list.getTotalElements());
//        model.addAttribute("list",list.getContent());

        /**
         * int getNumber();                     //현재 페이지
         * int getSize();                            //페이지 크기
         * int getTotalPages();                 //전체 페이지 수
         * int getNumberOfElements();   //현재 페이지에 나올 데이터 수
         * long getTotalElements();         //전체 데이터 수
         * boolean hasPreviousPage();    //이전 페이지 여부
         * boolean isFirstPage();              //현재 페이지가 첫 페이지 인지 여부
         * boolean hasNextPage();           //다음 페이지 여부
         * boolean isLastPage();               //현재 페이지가 마지막 페이지 인지 여부
         * Pageable nextPageable();         //다음 페이지 객체, 다음 페이지가 없으면 null
         * Pageable previousPageable();   //다음 페이지 객체, 이전 페이지가 없으면 null
         * List<T> getContent();               //조회된 데이터
         * boolean hasContent();              //조회된 데이터 존재 여부
         * Sort getSort();                           //정렬정보
         */

        model.addAttribute("page",boardService.findAll(boardDTO,pageRequest));
        return "board/list";
    }

    @PostMapping("/board")
    public String ins(
            @Valid BoardDTO boardDTO
            , BindingResult bindingResult
            ){
        if(bindingResult.hasErrors()){
            throw new NullPointerException("no data");
        }
        boardService.createBoard(boardDTO);
        return "redirect:/board";
    }
}
