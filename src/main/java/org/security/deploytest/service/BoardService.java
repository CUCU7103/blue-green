package org.security.deploytest.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.security.deploytest.controller.dto.BoardRequest;
import org.security.deploytest.domain.BoardEntity;
import org.security.deploytest.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void create(BoardRequest boardDto){
        BoardEntity board = new BoardEntity(boardDto.title(), boardDto.content(), boardDto.name());
        boardRepository.save(board);
    }

    public List<BoardInfo> getAll(){
       List<BoardEntity> boards =  boardRepository.findAll();
       return boards.stream().map(BoardInfo::from).toList();
    }

    public BoardInfo getById(long id){
        BoardEntity board =  boardRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자 입니다."));
        return BoardInfo.from(board);
    }

}
