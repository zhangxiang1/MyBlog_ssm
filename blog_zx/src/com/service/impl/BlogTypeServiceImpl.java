package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BlogTypeDao;
import com.entity.BlogType;
import com.service.BlogTypeService;

/**
 * ��������Serviceʵ����
 * @author Administrator
 *
 */
public class BlogTypeServiceImpl implements BlogTypeService{

	@Resource
	private BlogTypeDao blogTypeDao;
	
	public List<BlogType> countList() {
		return blogTypeDao.countList();
	}

	
}
