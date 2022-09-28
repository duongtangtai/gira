package cybersoft.javabackend.java18.gira.commons.utils;

import cybersoft.javabackend.java18.gira.commons.models.ResponseDTO;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Collections;

@UtilityClass
public class ResponseUtils {
    public static ResponseEntity<ResponseDTO> get(Object result, HttpStatus status) {
        return new ResponseEntity<>(
          ResponseDTO.builder()
                  .content(result)
                  .hasErrors(false)
                  .errors(Collections.emptyList())
                  .status(status.value())
                  .timestamp(DateTimeUtils.now())
                  .build()
                , status
        );
    }
    public static ResponseEntity<ResponseDTO> error(MethodArgumentNotValidException exception, HttpStatus status) {
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .content(null)
                        .hasErrors(true)
                        .errors(ExceptionUtils.getErrors(exception))
                        .status(status.value())
                        .timestamp(DateTimeUtils.now())
                        .build()
                , status
        );
    }
    public static ResponseEntity<ResponseDTO> error(RuntimeException exception, HttpStatus status) {
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .content(null)
                        .hasErrors(true)
                        .errors(ExceptionUtils.getErrors(exception))
                        .status(status.value())
                        .timestamp(DateTimeUtils.now())
                        .build()
                , status
        );
    }
}
