package Dao.Interface;

import Entity.PhieuDichVu;

public interface IPhieuDichVu extends IBaseDao<PhieuDichVu>{

	boolean addPhieuDichVuByMaPhong(int maPhong, int maDichVu,int soluong);
}
