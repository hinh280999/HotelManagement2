package RmiDto;

import java.io.Serializable;

// data transfer object 
public class SampleEntityInfoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int maTB;
	private String tenTB;
	private int maPhong;
	public int getMaTB() {
		return maTB;
	}
	public void setMaTB(int maTB) {
		this.maTB = maTB;
	}
	public String getTenTB() {
		return tenTB;
	}
	public void setTenTB(String tenTB) {
		this.tenTB = tenTB;
	}
	public int getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}
	
	public SampleEntityInfoDTO() {
		super();
	}
	public SampleEntityInfoDTO(int maTB, String tenTB, int maPhong) {
		super();
		this.maTB = maTB;
		this.tenTB = tenTB;
		this.maPhong = maPhong;
	}
	public SampleEntityInfoDTO(int maTB) {
		super();
		this.maTB = maTB;
	}
	@Override
	public String toString() {
		return "ThietBi [maTB=" + maTB + ", tenTB=" + tenTB + ", maPhong=" + maPhong + "]";
	}
}
