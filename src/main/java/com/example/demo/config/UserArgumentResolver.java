package com.example.demo.config;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.example.demo.pojo.User;
import com.example.demo.redis.RedisService;
import com.example.demo.redis.UserKey;

@Service
public class UserArgumentResolver implements HandlerMethodArgumentResolver{

	@Autowired
	private RedisService redisService;
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		Class<?> clazz=parameter.getParameterType();
		return clazz==User.class;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		HttpServletResponse response=webRequest.getNativeResponse(HttpServletResponse.class);
		HttpServletRequest request=webRequest.getNativeRequest(HttpServletRequest.class);
		String token=getCookieValue(request,"token");
		return redisService.get(UserKey.token, token, User.class);
	}

	private String getCookieValue(HttpServletRequest request, String tokenName) {
		Cookie[] cookies=request.getCookies();
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals(tokenName))
				return cookie.getValue();
		}
		return null;
	}

}
