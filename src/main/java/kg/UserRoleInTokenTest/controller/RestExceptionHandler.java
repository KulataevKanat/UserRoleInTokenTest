package kg.UserRoleInTokenTest.controller;

import kg.UserRoleInTokenTest.model.PremiseNotFoundException;
import kg.UserRoleInTokenTest.security.InvalidJwtAuthenticationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {PremiseNotFoundException.class})
    public ResponseEntity<?> vehicleNotFound(PremiseNotFoundException ex, WebRequest request) {
        return notFound().build();
    }

    @ExceptionHandler(value = {InvalidJwtAuthenticationException.class})
    public ResponseEntity<?> invalidJwtAuthentication(InvalidJwtAuthenticationException ex, WebRequest request) {
        return status(UNAUTHORIZED).build();
    }
}
