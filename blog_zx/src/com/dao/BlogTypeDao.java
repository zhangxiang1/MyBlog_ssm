package com.dao;

import java.util.List;

import com.entity.BlogType;

/**
 * ��������Dao�ӿ�
 * @author Administrator
 *
 */
public interface BlogTypeDao {

	/**
	 * ��ѯ���в������ͣ��Լ���Ӧ�Ĳ�������
	 * @return
	 */
	public List<BlogType> countList();
	
	/**
	 * ͨ��id���Ҳ�������ʵ��
	 * @param id
	 * @return
	 */
	public BlogType findById(Integer id);
	
	
}
