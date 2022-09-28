package cybersoft.javabackend.java18.gira.commons.exceptions;

import cybersoft.javabackend.java18.gira.commons.models.ResponseDTO;
import cybersoft.javabackend.java18.gira.commons.utils.ResponseUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException( //annotation validation exception
            MethodArgumentNotValidException exception
    ) {
        return ResponseUtils.error(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseDTO> handleRuntimeException(
            RuntimeException exception
    ) {
        return ResponseUtils.error(exception, HttpStatus.BAD_REQUEST);
    }
}
