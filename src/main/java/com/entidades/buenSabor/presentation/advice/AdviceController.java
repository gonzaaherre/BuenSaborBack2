package com.entidades.buenSabor.presentation.advice;

import com.entidades.buenSabor.MyException.RestrictDeleteException;
import com.entidades.buenSabor.domain.dto.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AdviceController {

    private static final Logger logger = LoggerFactory.getLogger(AdviceController.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDto> handleEmptyInput(Exception e){
        String errorMsg = e.getClass().getSimpleName()+ " : " + e.getMessage();
        logger.error(errorMsg);
        return ResponseEntity.internalServerError()
                .body(ErrorDto.builder()
                        .errorMsg(e.getMessage())
                        .errorClass(e.getClass().getSimpleName())
                        .build());
    }

    @ExceptionHandler(value = RestrictDeleteException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleRestrictDelete(RestrictDeleteException e){
        String errorMsg = e.getClass().getSimpleName() + " : " + e.getMessage();
        logger.error(errorMsg);
        return ResponseEntity.internalServerError().body(errorMsg);
    }
}

