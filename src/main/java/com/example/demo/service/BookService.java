package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BookMapper;
import com.example.demo.pojo.Book;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class BookService {
	
	@Autowired
	private BookMapper bookMapper;
	
	public List<Book> getBooks() {
		List<Book> books=bookMapper.selectAll();		
		return books;
	}


	public void addBook(Book book) {
		bookMapper.insert(book);
		
	}


	public List<Book> getBooksByName(String bookName) {
		Example example=new Example(Book.class);
		Criteria criteria=example.createCriteria();
		criteria.andLike("bookName", "%"+bookName+"%");
		//criteria.andEqualTo("bookName", bookName);
		List<Book> books=bookMapper.selectByExample(example);
		return books;
	}


	public List<Book> getBookdByType(String type) {
		Example example=new Example(Book.class);
		Criteria criteria=example.createCriteria();
		//criteria.andLike("bookName", "%"+type+"%");
		criteria.andEqualTo("bookType", type);
		List<Book> books=bookMapper.selectByExample(example);
		return books;
	}


	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
