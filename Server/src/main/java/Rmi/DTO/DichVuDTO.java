package Rmi.DTO;

import java.io.Serializable;

public class DichVuDTO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maDv;
	private String tenDv;
	private double donGia;

	public DichVuDTO() {
		super();
	}

	public DichVuDTO(int maDv) {
		super();
		this.maDv = maDv;
	}

	public DichVuDTO(String tenDv, double donGia) {
		super();
		this.tenDv = tenDv;
		this.donGia = donGia;
	}

	public int getMaDv() {
		return maDv;
	}

	public void setMaDv(int maDv) {
		this.maDv = maDv;
	}

	public String getTenDv() {
		return tenDv;
	}

	public void setTenDv(String tenDv) {
		this.tenDv = tenDv;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	@Override
	public String toString() {
		return "DichVuDTO [maDv=" + maDv + ", tenDv=" + tenDv + ", donGia=" + donGia + "]";
	}

}
