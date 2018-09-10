package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.result.Result;
import com.example.demo.service.UserService;
import com.example.demo.vo.LoginVo;

@RequestMapping("login")
@Service
public class LoginController {
	@Autowired 
	private UserService userService;
	
	@RequestMapping("toLogin")
	public String toLogin(){
		return "freemaker/index";
	}
	@RequestMapping("doLogin")
	@ResponseBody
	public Result<String> doLogin(HttpServletResponse response , @Valid LoginVo loginVo){
		String token=userService.login(response, loginVo);
		return Result.success(token);
	}
}
