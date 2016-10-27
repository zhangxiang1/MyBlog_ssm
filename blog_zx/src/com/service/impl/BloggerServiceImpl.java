package com.service.impl;

import javax.annotation.Resource;

import com.dao.BloggerDao;
import com.entity.Blogger;
import com.service.BloggerService;

/**
 * ����Serviceʵ����
 * @author Administrator
 *
 */
public class BloggerServiceImpl implements BloggerService{

	@Resource
	private BloggerDao bloggerDao;
	
	public Blogger getByUserName(String userName) {
		return bloggerDao.getByUserName(userName);
	}
	
	public Blogger find() {
		return bloggerDao.find();
	}

}
