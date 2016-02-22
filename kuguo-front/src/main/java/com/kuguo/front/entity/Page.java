package com.kuguo.front.entity;

import com.kuguo.front.utils.Constant;

/**
 * 分页信息
 * @author jerry
 *
 */
public class Page {
	private int pagenum;// 当前的页码：可以由页面层传递过来 *
	private int totalpage;// 总页数：可以从数据库中查询出来 *
	private int totalrecords;// 总记录数

	public Page(int pagenum, int totalrecords) {
		this.pagenum = pagenum;
		this.totalrecords = totalrecords;

		totalpage = (totalrecords % Constant.PAGE_NUMBER == 0) ? (totalrecords / Constant.PAGE_NUMBER) : (totalrecords
				/ Constant.PAGE_NUMBER + 1);
	}
}
