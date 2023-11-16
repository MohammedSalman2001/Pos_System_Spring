package lk.ijse.spring.adviser;

import lk.ijse.spring.util.StandResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin
public class AppWideExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<StandResponse> exceptionHandler(RuntimeException e){
        return new ResponseEntity<StandResponse>(
                new StandResponse(500,e.getMessage(),null), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
