package com.shareknows.websitebackend.model;

import org.springframework.data.domain.Page;

public class BasicResponse {
	
	private String message;
	private PageResponse page;
	
	public BasicResponse(String message) {
		this.message = message;
	}
	
	public BasicResponse(String message, Page<?> pageInfo) {
		this.message = message;
		if(pageInfo != null) {
			this.page = PageUtils.mapPageInfo(pageInfo);
		}
	}

	//************************
	// GETTERS + SETTERS
	//************************
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public PageResponse getPage() {
		return page;
	}

	public void setPage(PageResponse page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "BasicResponse [message=" + message + ", page=" + page + "]";
	}
	
}
