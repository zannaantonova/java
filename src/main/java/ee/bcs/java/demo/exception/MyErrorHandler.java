package ee.bcs.java.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handelError(Exception ex){
        System.out.println("handle exception here");
        return new ResponseEntity<Object>(new ErrorResponse(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
