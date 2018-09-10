package com.example.demo.exception;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.assertj.core.internal.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Eager;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.result.CodeMsg;
import com.example.demo.result.Result;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public Result<String> ExceptionHandler(HttpServletRequest servletRequest,Exception e) {
		e.printStackTrace();
		if(e instanceof GlobalException) {
			GlobalException globalException=(GlobalException) e;
			return Result.error(globalException.getCm());
		}else if(e instanceof BindException) {
			BindException ex = (BindException)e;
			List<ObjectError> errors = ex.getAllErrors();
			ObjectError error = errors.get(0);
			String msg = error.getDefaultMessage();
			return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
		}else {
			return Result.error(CodeMsg.SERVER_ERROR);
		}
	}
	
}
