package com.example.exceptionhandler_restcontrolleradvice_controlleravice.util;

import com.example.exceptionhandler_restcontrolleradvice_controlleravice.models.ErrorMess;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

// trong @Controller thì cũng sẽ dunng @ControllerAdvice
// và cách dùng giống trong @RestControllerAdvice

@RestControllerAdvice
public class ApiExceptionHandler {

    /*
     * tất cả các Exception không được khai
     * báo sẽ được xử lý tại đây
     * */

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMess handleAllException(Exception e, WebRequest request) {
        // quá trình kiểm soát lỗi diễn ra ở đây
        return new ErrorMess(191203, e.getLocalizedMessage());
    }

    /*
     * IndexOutOfBoundsException sẽ được xử lý riêng tại đây
     * */

    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMess GiangVienException(Exception e, WebRequest request) {
        return new ErrorMess(191111, "đối tượng không tồn tại trong lớp giảng viên");
    }

}
