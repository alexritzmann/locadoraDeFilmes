package belocadoradefilmes.locadoradefilmes.errors;

import belocadoradefilmes.locadoradefilmes.dtos.responses.ErrorResponseDto;
import belocadoradefilmes.locadoradefilmes.errors.exceptions.BadRequestException;
import belocadoradefilmes.locadoradefilmes.errors.exceptions.ConflictException;
import belocadoradefilmes.locadoradefilmes.errors.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalAdvice
{
    @ExceptionHandler(BadRequestException.class)
    private ResponseEntity<ErrorResponseDto> handleBadRequestException(BadRequestException ex)
    {
        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .code("400")
                .message(ex.getMessage())
                .cause("Bad Request")
                .exceptionClassName(ex.getClass().getName())
                .build();

        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(ConflictException.class)
    private ResponseEntity<ErrorResponseDto> handleConflictException(ConflictException ex)
    {
        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .code("409")
                .message(ex.getMessage())
                .cause("Conflict")
                .exceptionClassName(ex.getClass().getName())
                .build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(Exception ex)
    {
        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .code("404")
                .message(ex.getMessage())
                .cause("Resource Not Found")
                .exceptionClassName(ex.getClass().getName())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }


}
