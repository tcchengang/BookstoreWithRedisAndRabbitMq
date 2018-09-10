package com.example.demo.controller;


import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.pojo.Book;
import com.example.demo.pojo.User;
import com.example.demo.service.BookService;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("toListFirst")
	public String toListFirst(@CookieValue(value="token",required=false) String token,Model model,HttpServletResponse response){
		if(StringUtils.isEmpty(token))
			return "freemaker/index";
		User user=userService.getUserByToken(response,token);
		model.addAttribute("user", user);
		return "freemaker/bookstore";
	}
	@RequestMapping("toList")
	public String toList(User user, Model model,HttpServletResponse response){
		model.addAttribute("user", user);
		//PageHelper.startPage(pageNum, 5);
		List<Book> books=bookService.getBooks();
		//PageInfo pageInfo=new PageInfo(books,5);
		model.addAttribute("p", books.get(1));
		return "freemaker/bookstore";
	}
	
	
}
