package tn.esprit.autoloc.web.controller;
import tn.esprit.autoloc.exception.ResourceNotFoundException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.Map;
@RestControllerAdvice public class GlobalExceptionHandler {
 @ExceptionHandler(ResourceNotFoundException.class) @ResponseStatus(HttpStatus.NOT_FOUND)
 public Map<String,Object> notFound(ResourceNotFoundException e) { return Map.of("statut",404,"message",e.getMessage(),"horodatage",Instant.now().toString()); }
 @ExceptionHandler(IllegalArgumentException.class) @ResponseStatus(HttpStatus.BAD_REQUEST)
 public Map<String,Object> badRequest(IllegalArgumentException e) { return Map.of("statut",400,"message",e.getMessage(),"horodatage",Instant.now().toString()); }
}
