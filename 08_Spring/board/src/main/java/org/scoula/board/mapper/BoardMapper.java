package org.scoula.board.mapper;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;

import java.util.List;

public interface BoardMapper {

//    @Select("select * from tbl_board order by no desc")
    public List<BoardVO> getList();

    // GET(select)
    public BoardVO get(Long no);

    // CREATE
    public int create(BoardVO board);

    // UPDATE
    public int update(BoardVO board);

    // DELETE
    public int delete(Long no);




    // 첨부파일
    // 첨부파일 만들기 (VO -> x)
    public void createAttachment(BoardAttachmentVO attach);

    // attachment 리스트 가져오기 (bno -> List<VO>)
    public List<BoardAttachmentVO> getAttachmentList(Long bno);

    // attachment 가져오기 (no -> VO)
    public BoardAttachmentVO getAttachment(Long no);

    // 첨부파일 삭제하기 (no -> int)
    public int deleteAttachment(Long no);
}
