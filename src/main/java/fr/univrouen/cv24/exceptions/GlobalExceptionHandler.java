package fr.univrouen.cv24.exceptions;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ModelAndView handleValidationExceptions(MethodArgumentNotValidException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
