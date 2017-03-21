package com.cheyipai.platformservice.thirdparty.core.pager;

/**
 *	分页参数
 *
 * @author Wu CongWen
 * @email yubing744@163.com
 * @date 2013-8-15
 */
public class PagerParam {
	private int startIndex;
	private int count;
	
	public PagerParam(Integer startIndex, Integer count) {
		if (startIndex == null) {
			startIndex = 0;
		}
		
		if (count == null) {
			count = 10;
		}
		
		this.startIndex = startIndex;
		this.count = count;  
	}
	
	public int getPageNum() {
		return this.startIndex / this.count + 1;
	}
	
	public int getStartIndex() {
		return this.startIndex;
	}
	
	public int getPageSize() {
		return this.count;
	}
}
