package Rmi.DTO;

import java.io.Serializable;

public class PhongDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maP;
	private String ten;

	private LoaiPhongDTO maLP;

	private TinhTrangPhongDTO maTTP;

	public PhongDTO() {
		super();
	}

	public PhongDTO(int maP) {
		super();
		this.maP = maP;
	}

	public PhongDTO(String ten, LoaiPhongDTO maLP, TinhTrangPhongDTO maTTP) {
		super();
		this.ten = ten;
		this.maLP = maLP;
		this.maTTP = maTTP;
	}

	public int getMaP() {
		return maP;
	}

	public void setMaP(int maP) {
		this.maP = maP;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public LoaiPhongDTO getMaLP() {
		return maLP;
	}

	public void setMaLP(LoaiPhongDTO maLP) {
		this.maLP = maLP;
	}

	public TinhTrangPhongDTO getMaTTP() {
		return maTTP;
	}

	public void setMaTTP(TinhTrangPhongDTO maTTP) {
		this.maTTP = maTTP;
	}

	@Override
	public String toString() {
		return "PhongDTO [maP=" + maP + ", ten=" + ten + ", maLP=" + maLP.getTenLP() + ", maTTP=" + maTTP.getTenTTP()
				+ "]";
	}

}
