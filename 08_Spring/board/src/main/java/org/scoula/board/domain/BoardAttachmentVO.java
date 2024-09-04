package org.scoula.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.common.util.UploadFiles;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j
public class BoardAttachmentVO {


    private Long no;
    private Long bno; // FK: Board의 no
    private String filename; // 원본 파일명
    private String path; // 서버에 저장된 파일 경로
    private String contentType; // 파일 mime-type
    private Long size; // 파일의 크기
    private Date regDate; // 등록일

    // 팩토리 메소드
    // 객체 생성의 방법을 정의하지만, 생성할 객체의 구체적인 클래스는 서브클래스에서 결정하도록 하는 디자인 패턴
    public static BoardAttachmentVO of(MultipartFile part, Long bno, String path) {
        return builder()
                .bno(bno)
                .filename(part.getOriginalFilename())
                .path(path)
                .contentType(part.getContentType())
                .size(part.getSize())
                .build();
    }

    // 파일 크기 포맷 출력
    public String getFileSize() {
        return UploadFiles.getFormatSize(size);
    }
}
