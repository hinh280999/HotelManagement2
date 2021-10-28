package Model;

import java.util.List;

public class PageList<T> {
	private List<T> listData;
	private int currentPage;
	private int maxPage;

	public List<T> getListData() {
		return listData;
	}

	public void setListData(List<T> listData) {
		this.listData = listData;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public PageList(List<T> listData, int currentPage, int maxPage) {
		super();
		this.listData = listData;
		this.currentPage = currentPage;
		this.maxPage = maxPage;
	}

	public PageList() {
		super();
	}

}
