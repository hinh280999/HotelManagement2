package Rmi.DTO;

public class ChucVuDTO {
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
	public ChucVuDTO(int maCV, String tenCV, Double luong) {
		super();
		this.maCV = maCV;
		this.tenCV = tenCV;
		this.luong = luong;
	}
	public ChucVuDTO() {
		super();
	}
	
	
}
