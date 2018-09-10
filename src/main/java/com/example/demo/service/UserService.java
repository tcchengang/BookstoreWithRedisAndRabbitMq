package com.example.demo.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.junit.validator.PublicClassValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.GlobalException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.redis.RedisService;
import com.example.demo.redis.UserKey;
import com.example.demo.result.CodeMsg;
import com.example.demo.util.UUIDUtil;
import com.example.demo.vo.LoginVo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class UserService {
	
	public static final String COOKI_NAME_TOKEN = "token";
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RedisService redisService;
	
	public String login(HttpServletResponse response, LoginVo loginVo) {
		//public方法的参数都需要检验一下
		if(loginVo==null)
			throw new GlobalException(CodeMsg.MOBILE_EMPTY);
		String userName=loginVo.getUserName();
		String userPass=loginVo.getUserPass();
		User user=getUserByName(userName);
		if(user==null)
			throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
		//验证密码是否匹配
		if(!user.getUserPass().equals(userPass))
			throw new GlobalException(CodeMsg.PASSWORD_ERROR);
		String token =UUIDUtil.uuid();
		addCookie(response, token, user);
		return token;
		
	}

	private User getUserByName(String userName) {
		//	取缓存
		User user=redisService.get(UserKey.getByName, userName, User.class);
		if(user!=null)
			return user;
		Example example=new Example(User.class);
		Criteria criteria=example.createCriteria();
		criteria.andEqualTo("userName", userName);
		user=userMapper.selectOneByExample(example);	
		if(user!=null)
			redisService.set(UserKey.getByName, userName, user);
		return user;

	}
	public User getUserByToken(HttpServletResponse response,String token) {
		if(token==null)
			return null;
		User user=redisService.get(UserKey.token, token, User.class);
		//延长有效期
		if(user != null) 
			addCookie(response, token, user);
		return user;
	}
	private void addCookie(HttpServletResponse response, String token, User user) {
		redisService.set(UserKey.token, token, user);
		Cookie cookie = new Cookie(COOKI_NAME_TOKEN, token);
		cookie.setMaxAge(UserKey.token.expireSeconds());
		cookie.setPath("/");
		response.addCookie(cookie);
	}
}
