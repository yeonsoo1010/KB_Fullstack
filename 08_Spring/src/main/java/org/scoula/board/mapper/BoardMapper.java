package org.scoula.board.mapper;

import java.util.List;

import org.scoula.board.domain.BoardVO;


public interface BoardMapper {
    // get(select)
    public List<BoardVO> getList();
    public BoardVO get(Long no);

    // create
    public void create(BoardVO board);

    // update
    public int update(BoardVO board);

    // delete
    public int delete(Long no);
}
