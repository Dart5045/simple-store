package com.inditex.store.service.application.exception.handler;

import com.inditex.application.handler.ErrorDTO;
import com.inditex.application.handler.GlobalExceptionHandler;
import com.inditex.domain.exception.PriceNotFoundException;
import com.inditex.domain.exception.StoreDomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class StoreGlobalExceptionHandler extends GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {StoreDomainException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleException(StoreDomainException confirmationDomainException) {
        log.error(confirmationDomainException.getMessage(), confirmationDomainException);
        return ErrorDTO.builder()
                .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(confirmationDomainException.getMessage())
                .build();
    }

    @ResponseBody
    @ExceptionHandler(value = {PriceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(PriceNotFoundException confirmationNotFoundException) {
        log.error(confirmationNotFoundException.getMessage(), confirmationNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(confirmationNotFoundException.getMessage())
                .build();
    }
}
