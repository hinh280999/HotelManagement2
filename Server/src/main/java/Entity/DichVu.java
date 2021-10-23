package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "dichvus")
public class DichVu {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int maDv;
	private String tenDv;
	private String donGia;

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

	public String getDonGia() {
		return donGia;
	}

	public void setDonGia(String donGia) {
		this.donGia = donGia;
	}

	public DichVu(String tenDv, String donGia) {
		super();
		this.tenDv = tenDv;
		this.donGia = donGia;
	}

	public DichVu() {
		super();
	}

	public DichVu(int maDv) {
		super();
		this.maDv = maDv;
	}

}
