package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.scoula.common.util.UploadFiles;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j
@Service
@RequiredArgsConstructor // final 멤버를 인자로 가지는 생성자 추가
public class BoardServiceImpl implements BoardService {

    // 생성자가 1개인 경우 생성자 주입으로 초기화
    final private BoardMapper mapper;
    // 첨부파일 경로
    private final static String BASE_DIR = "c:/upload/board";

    @Override
    public List<BoardDTO> getList() {
        log.info("getList..........");

        return mapper.getList().stream() // BoardVO의 스트림
                .map(BoardDTO::of) // BoardDTO의 스트림
                .toList(); // List<BoardDTO> 변환
    }

    @Override
    public BoardDTO get(Long no) {
        log.info("get......" + no);

        BoardDTO board = BoardDTO.of(mapper.get(no));
        return Optional.ofNullable(board)
                .orElseThrow(NoSuchElementException::new);
    }

    // 원래 void 리턴이었음.
    // mapper.create만 하고 끝냈는데, 이제 get(boardVO.getNo())로 리턴
    // mapper.create -- boardVO -> int 리턴 (이 리턴값을 쓰지는 않는 듯)
    // boardVO의 getNo

    // 2개 이상의 insert 문이 실행될 수 있으므로 트랜잭션 처리 필요
    // RuntimeException인 경우만 자동 rollback
    @Override
    public BoardDTO create(BoardDTO board) {
        log.info("create......" + board);
        BoardVO boardVO= board.toVo(); // BoardDTO -> BoardVO
        mapper.create(boardVO);
        log.info("create......" + boardVO);

        // 파일 업로드 처리
        List<MultipartFile> files = board.getFiles();
        if (files != null && !files.isEmpty()) { // 첨부파일이 있는 경우
            upload(boardVO.getNo(), files);
        }
        return get(boardVO.getNo());
    }

    @Override
    public boolean update(BoardDTO board) {
        log.info("update......" + board);

        return mapper.update(board.toVo()) == 1;
    }


    @Override
    public boolean delete(Long no) {
        log.info("delete...." + no);

        return mapper.delete(no) == 1;
    }


    // upload
    private void upload(Long bno, List<MultipartFile> files) {
        for(MultipartFile part: files) {
            if(part.isEmpty()) continue;
            try {
                // 저장된 파일 경로 리턴 -> uploadPath
                String uploadPath = UploadFiles.upload(BASE_DIR, part);
                BoardAttachmentVO attach = BoardAttachmentVO.of(part, bno, uploadPath);
                mapper.createAttachment(attach);
            } catch (IOException e) {
                throw new RuntimeException(e); // @Transactional에서 감지, 자동 rollback
            }
        }
    }


    // attachment
    // 첨부파일 한 개 얻기
    @Override
    public BoardAttachmentVO getAttachment(Long no) {
        // 구현 내용 추가
        return mapper.getAttachment(no);
    }
    
    // 첨부파일 삭제
    @Override
    public boolean deleteAttachment(Long no) {
        // 구현 내용 추가
        return mapper.deleteAttachment(no) == 1;
    }

}
