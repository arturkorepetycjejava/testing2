package pl.arturzaczek.testing2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.arturzaczek.testing2.exception.AccessTokenException;
import pl.arturzaczek.testing2.exception.NoActiveProductException;
import pl.arturzaczek.testing2.exception.PrvtProfileTypeNotImplementedException;
import pl.arturzaczek.testing2.jpa.model.dto.ErrorResponse;

@ControllerAdvice
public class BusinessExceptionHandler {


    @ExceptionHandler(value = {AccessTokenException.class})
    ResponseEntity<ErrorResponse> handleAccessTokenException(final AccessTokenException e) {
        return ResponseEntity
                .badRequest()
                .body(ErrorResponse
                        .builder()
                        .code("400")
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(value = {NoActiveProductException.class})
    ResponseEntity<ErrorResponse> handleNoActiveProductException(final NoActiveProductException e) {
        return ResponseEntity
                .badRequest()
                .body(ErrorResponse
                        .builder()
                        .code("403")
                        .message("No active product in database")
                        .build());
    }

    @ExceptionHandler(value = {PrvtProfileTypeNotImplementedException.class})
    ResponseEntity<ErrorResponse> handlePrvtProfileTypeNotImplementedException(final PrvtProfileTypeNotImplementedException e) {
        return ResponseEntity
                .badRequest()
                .body(ErrorResponse
                        .builder()
                        .code("501")
                        .message(e.getMessage())
                        .build());
    }


}
