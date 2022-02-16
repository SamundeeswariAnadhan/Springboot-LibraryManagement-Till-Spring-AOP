package com.Library.Exception;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex,WebRequest req){
	ErrorHandle errHand=new ErrorHandle(new Date(),ex.getMessage(),req.getDescription(false));
	return new ResponseEntity<>(errHand,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception x,WebRequest req){
	ErrorHandle errHand=new ErrorHandle(new Date(),x.getMessage(),req.getDescription(false));
	return new ResponseEntity<>(errHand,HttpStatus.INTERNAL_SERVER_ERROR);

}
}