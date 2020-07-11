package ro.iteahome.medicom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ro.iteahome.medicom.exception.business.GlobalAlreadyExistsException;
import ro.iteahome.medicom.exception.business.GlobalNotFoundException;
import ro.iteahome.medicom.exception.business.NotNhsRegisteredException;
import ro.iteahome.medicom.exception.error.GlobalError;

public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

//  USER EXCEPTIONS: ---------------------------------------------------------------------------------------------------

    @ExceptionHandler(GlobalNotFoundException.class)
    public ResponseEntity<GlobalError> handleGlobalNotFoundException(GlobalNotFoundException ex) {
        return new ResponseEntity<>(new GlobalError(ex.getRestEntity().substring(0, 3) + "-01", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GlobalAlreadyExistsException.class)
    public ResponseEntity<GlobalError> handleGlobalAlreadyExistsException(GlobalAlreadyExistsException ex) {
        return new ResponseEntity<>(new GlobalError(ex.getEntityName().substring(0, 3) + "-02", ex.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotNhsRegisteredException.class)
    public ResponseEntity<GlobalError> handleNotNhsRegisteredException(NotNhsRegisteredException ex) {
        return new ResponseEntity<>(new GlobalError("NHS-01", ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
