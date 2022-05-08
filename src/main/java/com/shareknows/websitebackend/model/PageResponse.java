package com.shareknows.websitebackend.model;

public class PageResponse {

	private Integer selectedPage;
	private Integer maxPages;
	private Integer size;
	private Boolean isFirst;
	private Boolean isLast;

	public Integer getMaxPages() {
		return maxPages;
	}

	public void setMaxPages(Integer maxPages) {
		this.maxPages = maxPages;
	}

	public Integer getSelectedPage() {
		return selectedPage;
	}

	public void setSelectedPage(Integer selectedPage) {
		this.selectedPage = selectedPage;
	}

	public Boolean getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(Boolean isFirst) {
		this.isFirst = isFirst;
	}

	public Boolean getIsLast() {
		return isLast;
	}

	public void setIsLast(Boolean isLast) {
		this.isLast = isLast;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "PageResponse [selectedPage=" + selectedPage + ", maxPages=" + maxPages + ", size=" + size + ", isFirst="
				+ isFirst + ", isLast=" + isLast + "]";
	}

}
