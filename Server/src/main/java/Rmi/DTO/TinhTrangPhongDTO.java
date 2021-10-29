package Rmi.DTO;

import java.io.Serializable;

public class TinhTrangPhongDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maTTP;
	private String tenTTP;

	public int getMaTTP() {
		return maTTP;
	}

	public void setMaTTP(int maTTP) {
		this.maTTP = maTTP;
	}

	public String getTenTTP() {
		return tenTTP;
	}

	public void setTenTTP(String tenTTP) {
		this.tenTTP = tenTTP;
	}

	public TinhTrangPhongDTO(String tenTTP) {
		super();
		this.tenTTP = tenTTP;
	}

	public TinhTrangPhongDTO(int maTTP) {
		super();
		this.maTTP = maTTP;
	}

	public TinhTrangPhongDTO() {
		super();
	}

}
