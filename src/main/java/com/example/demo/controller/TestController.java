package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import com.example.demo.domain.User;
import com.example.demo.rabbitmq.MQSender;
import com.example.demo.redis.RedisService;
import com.example.demo.redis.UserKey;
import com.example.demo.result.Result;


@Controller
public class TestController {

	@Autowired
	private RedisService redisService;
	
	@Autowired
	ThymeleafViewResolver thymeleafViewResolver;
	
	@Autowired
	ApplicationContext applicationContext;
	

	@Autowired
	MQSender sender;
	
	@RequestMapping("test")
	@ResponseBody
	public Result<String> test() {
		return Result.success("hello");
	}
	
	@RequestMapping(value="/testlogin",produces="text/html")
	@ResponseBody
	public String testLogin(HttpServletRequest request, HttpServletResponse response, Model model) {
		WebContext ctx = new WebContext(request,response,
    			request.getServletContext(),request.getLocale(), model.asMap() );
    	//手动渲染
    	String html = thymeleafViewResolver.getTemplateEngine().process("freemaker/index", ctx);
    	redisService.set(UserKey.getById, "", html);

    	return html;
		//return "freemaker/index";
	}
	@RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> redisGet() {
    	User  user  = redisService.get(UserKey.getById, ""+1, User.class);
        return Result.success(user);
    }
    
    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet() {
    	User user  = new User();
    	user.setId(1);
    	user.setName("1111");
    	redisService.set(UserKey.getById, ""+1, user);//UserKey:id1
        return Result.success(true);
    }
    
  @RequestMapping("/mq")
  @ResponseBody
  public Result<String> mq() {
		sender.send("hello,imooc");
      return Result.success("Hello，world");
  }
}
