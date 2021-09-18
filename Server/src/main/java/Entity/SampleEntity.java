package Entity;

public class SampleEntity {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maPhong;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SampleEntity other = (SampleEntity) obj;
		if (maPhong != other.maPhong)
			return false;
		return true;
	}
	public SampleEntity() {
		super();
	}
	public SampleEntity(int maTB, String tenTB, int maPhong) {
		super();
		this.maTB = maTB;
		this.tenTB = tenTB;
		this.maPhong = maPhong;
	}
	public SampleEntity(int maTB) {
		super();
		this.maTB = maTB;
	}
	@Override
	public String toString() {
		return "ThietBi [maTB=" + maTB + ", tenTB=" + tenTB + ", maPhong=" + maPhong + "]";
	}
	
	
}
