package ee.bcs.java.demo.tasks;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyErrorHandler{
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleNullPointer(NullPointerException ne){
        System.out.println("Siia me saame koodi kirjutada");
        ErrorResponse response = new ErrorResponse();
        response.message = "Nullpointer viga";
        return new ResponseEntity<>(response, new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }




}
