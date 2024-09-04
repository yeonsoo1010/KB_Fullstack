package org.scoula.board.service;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    public List<BoardDTO> getList();

    public BoardDTO get(Long no);

    public BoardDTO create(BoardDTO boardDTO);

    public boolean update(BoardDTO boardDTO);

    public boolean delete(Long no);

    // 첨부파일
    // 첨부파일 1개 얻기: no -> BoardAttachmentVO
    public BoardAttachmentVO getAttachment(Long no);

    // 첨부파일 삭제: no -> delete
    public boolean deleteAttachment(Long no);
}
