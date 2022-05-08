package com.shareknows.websitebackend.model;

import org.springframework.data.domain.Page;

public class PageUtils {

	public static PageResponse mapPageInfo(Page<?> page) {
		PageResponse response = new PageResponse();
		response.setMaxPages(page.getTotalPages());
		response.setSelectedPage(page.getNumber());
		response.setIsFirst(page.isFirst());
		response.setIsLast(page.isLast());
		response.setSize(page.getSize());
		return response;
	}

}
