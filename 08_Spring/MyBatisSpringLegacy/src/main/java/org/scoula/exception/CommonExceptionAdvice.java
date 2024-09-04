package org.scoula.exception;

import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
//전역적으로 예외를 처리하는 클래스 정의
@Log4j
public class CommonExceptionAdvice {
    @ExceptionHandler(Exception.class)
    //모든 종류(Exception 클래스 및 그 하위 클래스)의 예외에 대해 처리할 메서드 정의
    public String except(Exception ex, Model model) {
        //Exception ex : 발생한 예외 객체
        //Model model : 뷰에 데이터를 전달하기 위한 모델 객체

        log.error("Exception ......." + ex.getMessage());
        model.addAttribute("exception", ex);
        //예외객체를 모델에 추가하여 뷰에서 사용할 수 있게 해준다.
        log.error(model);
        return "error_page";
    }

    //요청된 URL에 대해 컨트롤러가 없을 때 발생
    @ExceptionHandler(NoHandlerFoundException.class)

    //특정 예외(NoHandlerFoundException)을 처리하는 메서드를 정의
    @ResponseStatus(HttpStatus.NOT_FOUND)

    //이 메서드가 처리하는 예외에 대해 HTTP 상태 코드를 404로 설정
    public String handle404(NoHandlerFoundException ex) {
        return "custom404";
    }
}
