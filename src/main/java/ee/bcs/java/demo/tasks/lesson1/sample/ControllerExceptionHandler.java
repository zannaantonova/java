package ee.bcs.java.demo.tasks.lesson1.sample;

import ee.bcs.java.demo.tasks.lesson1.solution.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MyException.class)
    public ResponseEntity<Object> handleMyException(Exception ex) {
        ErrorResponse errorMessage = new ErrorResponse();
        errorMessage.setMessage(ex.getMessage());
        return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handelError(Exception ex) {
        System.out.println("juhtus viga");
        ex.printStackTrace();
        System.out.println("handle exception here");
        ErrorResponse errorMessage = new ErrorResponse();
        errorMessage.setMessage("Internal Server Error");
        return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
