package Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "phieuthues")
public class PhieuThue {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int maPT;
	private Date NgayDat;
	private Date NgayKetThuc;
	private Date NgayLap;

	@ManyToOne
	@JoinColumn(name = "maP")
	private Phong phong;
	@ManyToOne
	@JoinColumn(name = "maNV")
	private NhanVien nhanVien;
	@ManyToOne
	@JoinColumn(name = "maKH")
	private KhachHang khachHang;

	public int getMaPT() {
		return maPT;
	}

	public void setMaPT(int maPT) {
		this.maPT = maPT;
	}

	public Date getNgayDat() {
		return NgayDat;
	}

	public void setNgayDat(Date ngayDat) {
		NgayDat = ngayDat;
	}

	public Date getNgayKetThuc() {
		return NgayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		NgayKetThuc = ngayKetThuc;
	}

	public Date getNgayLap() {
		return NgayLap;
	}

	public void setNgayLap(Date ngayLap) {
		NgayLap = ngayLap;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public PhieuThue(Date ngayDat, Date ngayKetThuc, Date ngayLap) {
		super();
		NgayDat = ngayDat;
		NgayKetThuc = ngayKetThuc;
		NgayLap = ngayLap;
	}

	public PhieuThue(int maPT) {
		super();
		this.maPT = maPT;
	}

	public PhieuThue() {
		super();
	}

}
