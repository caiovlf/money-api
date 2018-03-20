package com.caiovlf.money.api.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MoneyExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String userMessage = messageSource.getMessage("mensagem.invalida", null,LocaleContextHolder.getLocale());
		String devMessage = ex.getCause().toString();
		
		List<Erro> erros = Arrays.asList(new Erro (userMessage, devMessage));
		
		return handleExceptionInternal(ex, erros  , headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<Erro> erros = criarListaDeErros(ex.getBindingResult());
		
		return handleExceptionInternal(ex, erros , headers, HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Erro> criarListaDeErros(BindingResult bindingResult){
		List<Erro> erros = new ArrayList<>();
		
		for(FieldError fieldError : bindingResult.getFieldErrors()) {
			String userMessage = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			String devMessage = fieldError.toString();
			erros.add(new Erro(userMessage, devMessage));
		}
		
		return erros;
	}
	
	public static class Erro {
		
		private String userMessage;
		private String devMessage;
		
		public Erro(String userMessage, String devMessage) {
			this.userMessage = userMessage;
			this.devMessage = devMessage;
		}
		
		public String getUserMessage() {
			return userMessage;
		}
		public String getDevMessage() {
			return devMessage;
		}
		
		
	}
	
}