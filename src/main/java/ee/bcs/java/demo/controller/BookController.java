package ee.bcs.java.demo.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController()
@Validated
public class BookController {

    @CrossOrigin(origins = "*")
    @GetMapping("account/{accountNr}")
    public Account getAccountBalance(@PathVariable("accountNr") String accountNr){
        if(accountNr.equals("1")){
            return new Account(new BigDecimal("25.5"));
        } else {
            return new Account(new BigDecimal("0"));
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("test")
    public Book test(){
        return new Book("Uus Raamat", "ABCDEFG");
    }

    @PostMapping("book")
    public Book saveBook(@Valid @RequestBody Book book, Errors errors) {
        System.out.println("here");
        System.out.println(errors.getErrorCount());
        return book;
    }

}
