package com.entity;

/**
 * ��ҳModel��
 * @author 
 *
 */
public class PageBean {

	private int page; // �ڼ�ҳ
	private final static int pageSize = 2; // ÿҳ��¼��
	private int start;  // ��ʼҳ
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public int getStart() {
		return (page-1)*pageSize;
	}
	
	
}
