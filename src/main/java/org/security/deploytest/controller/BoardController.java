package org.security.deploytest.controller;

import lombok.RequiredArgsConstructor;
import org.security.deploytest.controller.dto.BoardRequest;
import org.security.deploytest.controller.dto.ListResponse;
import org.security.deploytest.controller.dto.SingleResponse;
import org.security.deploytest.service.BoardInfo;
import org.security.deploytest.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @PostMapping
    public void create(@RequestBody BoardRequest dto ){
        boardService.create(dto);
    }


    @GetMapping
    public ResponseEntity<ListResponse> getAll(){
        return ResponseEntity.ok().body(ListResponse.of("성공", boardService.getAll()));
    }


    @GetMapping("/{id}")
    public ResponseEntity<SingleResponse> getById(@PathVariable long id){
        return ResponseEntity.ok().body(SingleResponse.of("성공", boardService.getById(id)));
    }

}
