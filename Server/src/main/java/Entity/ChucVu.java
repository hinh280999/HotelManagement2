package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "chucvus")
public class ChucVu {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int maCV;
	private String tenCV;
	private Double luong;

	public int getMaCV() {
		return maCV;
	}

	public void setMaCV(int maCV) {
		this.maCV = maCV;
	}

	public String getTenCV() {
		return tenCV;
	}

	public void setTenCV(String tenCV) {
		this.tenCV = tenCV;
	}

	public Double getLuong() {
		return luong;
	}

	public void setLuong(Double luong) {
		this.luong = luong;
	}

	public ChucVu(String tenCV, Double luong) {
		super();
		this.tenCV = tenCV;
		this.luong = luong;
	}

	public ChucVu() {
		super();
	}

}
