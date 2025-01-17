package tobeto.HotelReservationSystem.core.configurations;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tobeto.HotelReservationSystem.core.utils.exceptions.details.BusinessProblemDetails;
import tobeto.HotelReservationSystem.core.utils.exceptions.details.ValidationProblemDetails;
import tobeto.HotelReservationSystem.core.utils.exceptions.types.BusinessException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails businessExceptionHandle(BusinessException exception){

        BusinessProblemDetails businessProblemDetails = new BusinessProblemDetails(exception.getMessage());

        return businessProblemDetails;
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails validationExceptionHandle(MethodArgumentNotValidException exception){
        List<String> errorMessages = new ArrayList<>();

        List<FieldError> errors = exception.getBindingResult().getFieldErrors();

        for (FieldError error:errors){
            errorMessages.add(error.getDefaultMessage());
        }
        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails(errorMessages);

        return  validationProblemDetails;
    }
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleRuntimeException(BusinessException exception)
    {
        return exception.getMessage();
    }
}
