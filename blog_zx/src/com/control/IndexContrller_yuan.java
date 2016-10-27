package com.control;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Blog;
import com.entity.PageBean;
import com.service.BlogService;
import com.util.PageUtil;

/**
 * ��ҳContrller
 * @author Administrator
 * ��ҵע���Ѿ����ҳ����ˣ�������Ŀ�ᱨ��
 * springmvc �ϰ汾����������д��Դ��
 * 
 */
public class IndexContrller_yuan {

	@Resource
	private BlogService blogService;
	
	/**
	 * ������ҳ
	 * @return
	 */
	
	public ModelAndView index(
			@RequestParam(value="page",required=false)String page,
			@RequestParam(value="typeId",required=false)String typeId,
			@RequestParam(value="releaseDateStr",required=false)String releaseDateStr,HttpServletRequest request)throws Exception{
		
		ModelAndView mav=new ModelAndView();
		
		if(page == null  || "".equals(page.trim())){
			page="1";
		}
		
		PageBean pageBean = new PageBean();
		pageBean.setPage(Integer.parseInt(page));

		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		map.put("typeId", typeId);
		map.put("releaseDateStr", releaseDateStr);
		 
		List<Blog> blogList=blogService.list(map);
		
		// ʹ��Jsoup������html�е�imgԪ��
		for(Blog blog:blogList){
			String blogInfo=blog.getContent();
			Document doc=Jsoup.parse(blogInfo);
			Elements jpgs=doc.select("img[src$=.jpg]");
			
			List<String> imageList = new LinkedList<String>();
			for(int i=0;i<jpgs.size();i++){
				Element jpg=jpgs.get(i);
				
				imageList.add(jpg.toString());
				
				blog.setImageList(imageList);
				
				if(i==2){  //��ҳչʾ
					break;
				}
			}
		}
		
		mav.addObject("blogList", blogList);
		StringBuffer param=new StringBuffer();
		mav.addObject("pageCode", PageUtil.genPagination(request.getContextPath()+"/index.html", blogService.getTotal(), Integer.parseInt(page), pageBean.getPageSize(), param.toString()));
		mav.addObject("pageTitle", "java��Դ����ϵͳ");
		mav.addObject("mainPage", "foreground/blog/list.jsp");
		mav.setViewName("mainTemp");
		return mav;
	}
}
