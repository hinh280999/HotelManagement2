package Rmi.DTO;

import java.io.Serializable;
import java.util.Date;

public class PhieuThueDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maPT;
	private Date ngayDat;
	private Date ngayKetThuc;
	private Date ngayLap;
	private Date ngayNhan;
	private Date ngayTra;
	private String trangThai;

	private PhongDTO phong;

	private NhanVienDTO nhanVien;

	private KhachHangDTO khachHang;

	public PhieuThueDTO() {
		super();
	}

	public PhieuThueDTO(int maPT) {
		super();
		this.maPT = maPT;
	}

	public PhieuThueDTO(Date ngayDat, Date ngayKetThuc, Date ngayLap, PhongDTO phong, NhanVienDTO nhanVien,
			KhachHangDTO khachHang) {
		super();
		this.ngayDat = ngayDat;
		this.ngayKetThuc = ngayKetThuc;
		this.ngayLap = ngayLap;
		this.phong = phong;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.trangThai = "NEW";
	}

	public int getMaPT() {
		return maPT;
	}

	public void setMaPT(int maPT) {
		this.maPT = maPT;
	}

	public Date getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public Date getNgayNhan() {
		return ngayNhan;
	}

	public void setNgayNhan(Date ngayNhan) {
		this.ngayNhan = ngayNhan;
	}

	public Date getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public PhongDTO getPhong() {
		return phong;
	}

	public void setPhong(PhongDTO phong) {
		this.phong = phong;
	}

	public NhanVienDTO getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVienDTO nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHangDTO getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHangDTO khachHang) {
		this.khachHang = khachHang;
	}

	@Override
	public String toString() {
		return "PhieuThueDTO [maPT=" + maPT + ", ngayDat=" + ngayDat + ", ngayKetThuc=" + ngayKetThuc + ", ngayLap="
				+ ngayLap + ", ngayNhan=" + ngayNhan + ", ngayTra=" + ngayTra + ", trangThai=" + trangThai + ", phong="
				+ phong.getTen() + ", nhanVien=" + nhanVien.getTen() + ", khachHang=" + khachHang.getTen() + "]";
	}

}
