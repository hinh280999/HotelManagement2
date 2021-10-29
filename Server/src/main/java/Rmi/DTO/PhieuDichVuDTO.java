package Rmi.DTO;

import java.io.Serializable;
import java.util.Date;

public class PhieuDichVuDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maPDV;
	private int soLuong;
	private Date ngayLap;
	private boolean daThanhToan;

	private PhieuThueDTO phieuThue;
	private DichVuDTO dichVu;

	public PhieuDichVuDTO() {
		super();
	}

	public PhieuDichVuDTO(int soLuong, Date ngayLap, PhieuThueDTO phieuThue, DichVuDTO dichVu) {
		super();
		this.soLuong = soLuong;
		this.ngayLap = ngayLap;
		this.phieuThue = phieuThue;
		this.dichVu = dichVu;
	}
	

	public PhieuDichVuDTO(int maPDV) {
		super();
		this.maPDV = maPDV;
	}

	public int getMaPDV() {
		return maPDV;
	}

	public void setMaPDV(int maPDV) {
		this.maPDV = maPDV;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public boolean isDaThanhToan() {
		return daThanhToan;
	}

	public void setDaThanhToan(boolean daThanhToan) {
		this.daThanhToan = daThanhToan;
	}

	public PhieuThueDTO getPhieuThue() {
		return phieuThue;
	}

	public void setPhieuThue(PhieuThueDTO phieuThue) {
		this.phieuThue = phieuThue;
	}

	public DichVuDTO getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVuDTO dichVu) {
		this.dichVu = dichVu;
	}
	
	

}
