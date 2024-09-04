package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j
@RequestMapping("/board") // url 분기
@RequiredArgsConstructor
public class BoardController {
    final private BoardService service;

    // 1. list url 글 목록 보이게
    @GetMapping("/list")
    public void list(Model model) {

        log.info(model);
        model.addAttribute("list", service.getList());

    }

    // 2. create,, RedirectAttributes 추가
    @GetMapping("/create")
    public void create() {
        log.info("create");
    }

    @PostMapping("/create")
    public String create(BoardDTO board, RedirectAttributes ra) {
        log.info("create1: " + board);
        // service.create(board);를 하니까 리턴값이 없는 상태.
        // service.create(board)의 리턴값이 필요함. --> serviceImpl의 create 확인하기
        // 밑에서 다시 board.getNo()로 하면 매개변수로 받은 board의 No를 뽑아서 null이 나옴.
        // board = service.create(board)로 한다음에 뒤에 result에 board.getNo()로 해줘도 ok.

        //BoardDTO로 리턴
        ra.addFlashAttribute("result", service.create(board).getNo());

        return "redirect:/board/list";
    }

    // 3. 조회 get, update --> 업데이트할 때도 조회
    @GetMapping({"/get", "/update"})
    public void get(@RequestParam("no") Long no, Model model) {
        log.info("/get or update");

        model.addAttribute("board", service.get(no));
    }

    // 4. update,, RedirectAttributes
    @PostMapping("/update")
    public String update(BoardDTO board, RedirectAttributes ra) {
        log.info("update:" + board);
        if (service.update(board)) {
            ra.addFlashAttribute("result", "success");
        }

        return "redirect:/board/list";
    }


    // 5. delete
    @PostMapping("/delete")
    public String delete(@RequestParam("no") Long no, RedirectAttributes ra) {
        log.info("delete..." + no);
        if (service.delete(no)) {
            ra.addFlashAttribute("result", "success");
        };
        return "redirect:/board/list";
    }

}
