package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Link;

/**
 * ��������Dao�ӿ�
 * @author Administrator
 *
 */
public interface LinkDao {

	/**
	 * ��������������Ϣ
	 * @param map
	 * @return
	 */
	public List<Link> list();
}
