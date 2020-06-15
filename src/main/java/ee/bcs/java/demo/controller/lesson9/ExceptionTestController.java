package ee.bcs.java.demo.controller.lesson9;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("test-exception")
@RestController()
public class ExceptionTestController {

    @GetMapping("test-error")
    public String testError() {

        throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Something is mandatory");
    }

    @GetMapping("throw-error")
    public String errorTest() {
        throw new RuntimeException();
    }
}
