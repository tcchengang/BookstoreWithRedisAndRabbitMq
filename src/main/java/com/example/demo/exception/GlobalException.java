package com.example.demo.exception;

import com.example.demo.result.CodeMsg;
import com.example.demo.result.Result;

public class GlobalException extends RuntimeException{

	/**
	 * 定义全局异常
	 */
	private static final long serialVersionUID = 1L;
	
	private CodeMsg codeMsg;
	public GlobalException(CodeMsg codeMsg) {
		super(codeMsg.toString());
		this.codeMsg=codeMsg;
	}
	public CodeMsg getCm() {
		return codeMsg;
	}
}
